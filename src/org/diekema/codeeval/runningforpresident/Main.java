package org.diekema.codeeval.runningforpresident;

import java.io.*;
import java.util.*;

/**
 * Created by rdiekema on 5/1/15.
 */
public class Main {
    static int numberOfIssues = 0;
    static Map<String, Integer> issuesCostsMap = new HashMap<>();
    static Map<State, Map<String, Integer>> statesVotesIssuesMap = new HashMap<>();
    static Map<String, Integer> issueVoteCountMap = new HashMap<>();
    static Integer ELECTORAL_MAJORITY = 9;

    static List<List<String>> simulatedCampaigns = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line = bufferedReader.readLine();

            // Parse Issues, count, and costs
            numberOfIssues = Integer.valueOf(line.substring(line.indexOf(":") + 2, line.length()));
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();

            while (line.length() != 0) {
                issuesCostsMap.put(line.substring(0, line.indexOf(':')), Integer.valueOf(line.substring(line.indexOf(':') + 2, line.length())));
                issueVoteCountMap.put(line.substring(0, line.indexOf(':')), 0);
                line = bufferedReader.readLine();
            }

            line = bufferedReader.readLine();

            while (line != null && line.length() != 0) {
                State state = new State();
                state.issuesVotesMap = new HashMap<>();

                state.name = line.substring(0, line.length());
                line = bufferedReader.readLine();
                state.votes = Integer.valueOf(line.substring(line.indexOf(':') + 2, line.length()).trim());
                line = bufferedReader.readLine();

                String issueName = "";
                Integer voteCount = 0;
                while (line != null && line.length() != 0) {
                    issueName = line.substring(0, line.indexOf(':'));
                    voteCount = Integer.valueOf(line.substring(line.indexOf(':') + 2, line.length()));
                    state.issuesVotesMap.put(issueName, voteCount);
                    if (issueVoteCountMap.containsKey(issueName)) {
                        issueVoteCountMap.put(issueName, issueVoteCountMap.get(issueName) + voteCount);
                    }
                    line = bufferedReader.readLine();
                }
                line = bufferedReader.readLine();

                statesVotesIssuesMap.put(state, state.issuesVotesMap);
            }

            simulateCampaigns();
            simulateCampaigns2();

            List<String> optimalCampaign = determineOptimalCampaign();
            Collections.sort(optimalCampaign);
            for (String issue : optimalCampaign) {
                System.out.println(issue);
            }

        }
    }

    static List<String> determineOptimalCampaign() {
        Integer cheapestCampaignValue = Integer.MAX_VALUE;
        Integer currentCampaignTotal = 0;
        Integer fewestIssueCount = Integer.MAX_VALUE;

        List<String> fewestIssues = new ArrayList<>();
        for (List<String> simulatedCampaign : simulatedCampaigns) {
            if (simulatedCampaign.size() < fewestIssueCount) {
                fewestIssueCount = simulatedCampaign.size();
                fewestIssues = simulatedCampaign;
            }
        }

        List<String> cheapestCampaign = new ArrayList<>();
        // Calculate cost for all campaigns
        for (List<String> simulatedCampaign : simulatedCampaigns) {

            // Calculate campaign cost
            for (String issue : simulatedCampaign) {
                currentCampaignTotal += issuesCostsMap.get(issue);
            }

            if (currentCampaignTotal < cheapestCampaignValue) {
                cheapestCampaign = simulatedCampaign;
            }
        }

        return cheapestCampaign.size() > fewestIssues.size() ? fewestIssues : cheapestCampaign;
    }

    static void simulateCampaigns() {
        List<State> orderedStates = new ArrayList<>();
        orderedStates.addAll(statesVotesIssuesMap.keySet());
        Collections.sort(orderedStates);

        LinkedList<Map.Entry<String, Integer>> linkedList = new LinkedList(issueVoteCountMap.entrySet());

        Collections.sort(linkedList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        Iterator<Map.Entry<String, Integer>> linkedListIterator = linkedList.iterator();
        while (linkedListIterator.hasNext()) {
            List<String> hypotheticalCampaign = new ArrayList<>();
            Integer campaignTotal = 0;
            int i = 0;
            while (linkedListIterator.hasNext() && campaignTotal < ELECTORAL_MAJORITY) {
                hypotheticalCampaign.add(linkedListIterator.next().getKey());
                for (State state : orderedStates) {
                    if (winState(state, hypotheticalCampaign)) {
                        campaignTotal += state.votes;
                        if (campaignTotal >= ELECTORAL_MAJORITY) {
                            break;
                        }
                    }
                    if (campaignTotal >= ELECTORAL_MAJORITY) {
                        break;
                    }
                }
                i++;
            }

            simulatedCampaigns.add(hypotheticalCampaign);
        }
    }

    static void simulateCampaigns2() {
        List<State> orderedStates = new ArrayList<>();
        orderedStates.addAll(statesVotesIssuesMap.keySet());
        Collections.sort(orderedStates);
        Collections.reverse(orderedStates);

        LinkedList<Map.Entry<String, Integer>> linkedList = new LinkedList(issueVoteCountMap.entrySet());

        Collections.sort(linkedList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        /*
         In ordered states there is a list of states ordered by the total number of votes available.
         In the original method the simulation iterated over all of the state and added a new issue
         to the hypothetical campaign and then check to see if that issue won enough votes to push
         the election over the ELECTORAL_MAJORITY threshold. in simulateCampaigns2 the goal will be
         to start in the reverse order with the states to build a second set of potential campaigns
         starting with the states having the fewest numbers of votes, but still ordering the issues
         by overall available vote count. This should give a few new hypothetical campaigns that
         provide a way to get to 270 votes without the election being dominated by the larger state
         priorities.
          */

        Iterator<Map.Entry<String, Integer>> linkedListIterator = linkedList.iterator();
        while (linkedListIterator.hasNext()) {
            List<String> hypotheticalCampaign = new ArrayList<>();
            Integer campaignTotal = 0;
            int i = 0;
            while (linkedListIterator.hasNext() && campaignTotal < ELECTORAL_MAJORITY) {
                hypotheticalCampaign.add(linkedListIterator.next().getKey());
                for (State state : orderedStates) {
                    if (winState(state, hypotheticalCampaign)) {
                        campaignTotal += state.votes;
                        if (campaignTotal >= ELECTORAL_MAJORITY) {
                            break;
                        }
                    }
                    if (campaignTotal >= ELECTORAL_MAJORITY) {
                        break;
                    }
                }
                i++;
            }

            simulatedCampaigns.add(hypotheticalCampaign);
        }

    }

    static boolean winState(State state, List<String> issues) {
        Double electoralVotes = state.votes.doubleValue();

        Double votesWonByIssues = 0d;
        for (String issue : issues) {
            if (state.issuesVotesMap.containsKey(issue)) {
                votesWonByIssues += state.issuesVotesMap.get(issue);
                if (new Double(votesWonByIssues / electoralVotes).compareTo(.51d) > 0) {
                    return true;
                }
            }
        }

        return false;
    }


    static class State implements Comparable<State> {
        public String name;
        public Integer votes;
        public Map<String, Integer> issuesVotesMap = new TreeMap<>();

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getVotes() {
            return this.votes;
        }

        public void setVotes(Integer votes) {
            this.votes = votes;
        }

        public int getVotesForIssue(String issue) {
            return issuesVotesMap.containsKey(issue) ? issuesVotesMap.get(issue) : 0;
        }

        @Override
        public int compareTo(State o) {
            return o.getVotes().compareTo(this.votes);
        }
    }
}