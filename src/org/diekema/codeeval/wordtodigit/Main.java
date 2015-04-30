package org.diekema.codeeval.wordtodigit;

import java.io.*;

/**
 * Created by rdiekema on 4/30/15.
 */
public class Main {
    static final String ZERO = "zero";
    static final String ONE = "one";
    static final String TWO = "two";
    static final String THREE = "three";
    static final String FOUR = "four";
    static final String FIVE = "five";
    static final String SIX = "six";
    static final String SEVEN = "seven";
    static final String EIGHT = "eight";
    static final String NINE = "nine";

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringBuilder stringBuilder = new StringBuilder(32);
                String[] stringDigits = line.split(";");

                for (String digit : stringDigits) {
                    switch (digit) {
                        case ZERO:
                            stringBuilder.append(0);
                            break;
                        case ONE:
                            stringBuilder.append(1);
                            break;
                        case TWO:
                            stringBuilder.append(2);
                            break;
                        case THREE:
                            stringBuilder.append(3);
                            break;
                        case FOUR:
                            stringBuilder.append(4);
                            break;
                        case FIVE:
                            stringBuilder.append(5);
                            break;
                        case SIX:
                            stringBuilder.append(6);
                            break;
                        case SEVEN:
                            stringBuilder.append(7);
                            break;
                        case EIGHT:
                            stringBuilder.append(8);
                            break;
                        case NINE:
                            stringBuilder.append(9);
                            break;
                    }
                }

                System.out.println(stringBuilder.toString());
            }

            bufferedReader.close();
        }
    }
}
