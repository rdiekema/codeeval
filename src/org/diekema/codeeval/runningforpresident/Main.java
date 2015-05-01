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
    static Integer ELECTORAL_MAJORITY = 10;

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
                while (line != null && line.length() != 0) {
                    state.issuesVotesMap.put(line.substring(0, line.indexOf(':')), Integer.valueOf(line.substring(line.indexOf(':') + 2, line.length())));
                    line = bufferedReader.readLine();
                }
                line = bufferedReader.readLine();

                statesVotesIssuesMap.put(state, state.issuesVotesMap);
            }

            // Now that we've processed all of the states and the votes
            for (String issue : determineOptimalCampaign()) {
                System.out.println(issue);
            }
        }
    }

    static List<String> determineOptimalCampaign() {
        List<String> campaignIssues = new ArrayList<>();
        campaignIssues.addAll(issuesCostsMap.keySet());

        List<State> orderedStates = new ArrayList<>();
        orderedStates.addAll(statesVotesIssuesMap.keySet());
        Collections.sort(orderedStates);

        List<String> hypotheticalCampaign = new ArrayList<>();
        Integer campaignTotal = 0;
        int i = 0;
        while (i < campaignIssues.size() && campaignTotal < ELECTORAL_MAJORITY) {
            hypotheticalCampaign.add(campaignIssues.get(i));
            for (State state : orderedStates) {
                if (winState(state, hypotheticalCampaign)) {
                    campaignTotal += state.votes;
                }
            }
            i++;
        }

        return hypotheticalCampaign;
    }

    static boolean winState(State state, List<String> issues) {
        Double electoralVotes = state.votes.doubleValue();

        Double votesWonByIssues = 0d;
        for (String issue : issues) {
            if (state.issuesVotesMap.containsKey(issue)) {
                votesWonByIssues += state.issuesVotesMap.get(issue);
                if (votesWonByIssues / electoralVotes > .51d) {
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
