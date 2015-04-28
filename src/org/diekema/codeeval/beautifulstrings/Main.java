package org.diekema.codeeval.beautifulstrings;

import java.io.*;
import java.util.*;

/**
 * Created by rdiekema on 4/28/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                char[] string = line.toUpperCase().replaceAll("\\p{Punct}|\\s", "").replaceAll("\\d", "").toCharArray();

                List<RankedCharacter> rankedCharacters = new ArrayList<RankedCharacter>();
                for (Character character : string) {
                    if(rankedCharacters.contains(new RankedCharacter(character))){
                        Integer currentCount = rankedCharacters.get(rankedCharacters.indexOf(new RankedCharacter(character))).getOccurrences();
                        int index = rankedCharacters.indexOf(new RankedCharacter(character));
                        rankedCharacters.remove(index);
                        rankedCharacters.add(index, new RankedCharacter(character, currentCount +1));
                    }
                    else{
                        rankedCharacters.add(new RankedCharacter(character, 1));
                    }
                }

                Collections.sort(rankedCharacters);
                int i = 26;
                int score = 0;
                for(RankedCharacter rankedCharacter : rankedCharacters){
                    score += rankedCharacter.getOccurrences() * i;
                    --i;
                }
                System.out.println(score);
            }
        }
    }

    public static class RankedCharacter implements Comparable<RankedCharacter> {
        Character character;
        Integer occurrences;

        public RankedCharacter(Character character) {
            this.character = character;
        }

        public RankedCharacter(Character character, Integer occurrences) {
            this.character = character;
            this.occurrences = occurrences;
        }

        @Override
        public int compareTo(RankedCharacter o) {
            return o.getOccurrences().compareTo(this.occurrences);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RankedCharacter that = (RankedCharacter) o;
            return Objects.equals(character, that.character);
        }

        public Integer getOccurrences() {
            return occurrences;
        }
    }
}