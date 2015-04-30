package org.diekema.codeeval.withoutrepetitions;

import java.io.*;
import java.util.Stack;

/**
 * Created by rdiekema on 4/29/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Stack<Character> characterStack = new Stack<Character>();
                Stack<Character> results = new Stack<Character>();

                StringBuilder stringBuilder = new StringBuilder();
                for (Character character : line.toCharArray()) {
                    characterStack.push(character);
                }

                while (!characterStack.isEmpty()) {
                    Character currentCharacter = characterStack.pop();

                    while (!characterStack.isEmpty() && currentCharacter.equals(characterStack.peek())) {
                        characterStack.pop();
                    }

                    results.push(currentCharacter);
                }

                while (!results.isEmpty()) {
                    stringBuilder.append(results.pop());
                }

                System.out.println(stringBuilder.toString());
            }
            bufferedReader.close();
        }
    }
}
