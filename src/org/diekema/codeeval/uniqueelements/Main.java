package org.diekema.codeeval.uniqueelements;

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
                Stack<Integer> integers = new Stack<Integer>();
                Stack<Integer> results = new Stack<Integer>();

                for (String integer : line.split(",")) {
                    integers.add(Integer.valueOf(integer));
                }

                StringBuilder stringBuilder = new StringBuilder();

                while(!integers.isEmpty()){
                    Integer currentInt = integers.pop();

                    while(!integers.isEmpty() && currentInt.equals(integers.peek())){
                        integers.pop();
                    }

                    results.push(currentInt);
                }

                while(!results.isEmpty()){
                    stringBuilder.append(results.pop());
                    stringBuilder.append(",");
                }

                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                System.out.println(stringBuilder.toString());
            }
        }
    }
}
