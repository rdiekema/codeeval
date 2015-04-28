package org.diekema.codeeval.stackimplementation;

import java.io.*;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by rdiekema on 4/27/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Stack<Integer> stack = new Stack<Integer>();

                String[] integers = line.split("\\s");

                for (String integer : integers) {
                    stack.push(Integer.parseInt(integer));
                }

                StringBuilder stringBuilder = new StringBuilder();
                while (!stack.isEmpty()) {
                    stringBuilder.append(stack.pop()).append(" ");

                    try {
                        stack.pop();
                    } catch (EmptyStackException e) {
                        break;
                    }
                }

                stringBuilder.append("\n");
                System.out.print(stringBuilder.toString());
            }
        }
    }
}

