package org.diekema.codeeval.hextodecimal;

import java.io.*;

/**
 * Created by rdiekema on 4/29/15.
 */
public class Main {

    static char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                char[] number = line.toCharArray();

                int total = 0;
                int power = 0;
                for (int i = number.length - 1; i >= 0; i--) {
                    for (int j = 0; j < HEX.length; j++) {
                        if (HEX[j] == number[i]) {
                            total += Math.pow(16, power) * j;
                        }
                    }
                    power++;
                }

                System.out.println(total);
            }
            bufferedReader.close();
        }
    }
}
