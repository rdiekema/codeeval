package org.diekema.codeeval.swapelements;

import java.io.*;

/**
 * Created by rdiekema on 4/30/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String integerString = line.split(" : ")[0];
                String swapString = line.split(" : ")[1];

                String[] integerStrings = integerString.split(" ");
                String[] swaps = swapString.split(", ");

                int[] ints = new int[integerStrings.length];
                for (int i = 0; i < integerStrings.length; i++) {
                    ints[i] = Integer.valueOf(integerStrings[i]);
                }

                for (String swap : swaps) {
                    int x = Integer.valueOf(swap.substring(0, swap.indexOf('-')));
                    int y = Integer.valueOf(swap.substring(swap.indexOf('-') + 1, swap.length()));

                    int z = ints[x];
                    ints[x] = ints[y];
                    ints[y] = z;
                }

                StringBuilder stringBuilder = new StringBuilder();
                for (int integer : ints) {
                    stringBuilder.append(integer).append(" ");
                }

                System.out.println(stringBuilder.toString().trim());
            }
        }
    }
}
