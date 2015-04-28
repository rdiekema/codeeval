package org.diekema.codeeval.bigdigits;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rdiekema on 4/28/15.
 */
public class Main {

    static boolean[][] SPACE = {
            {false},
            {false},
            {false},
            {false},
    };

    static boolean[][] ZERO = {
            {false, true, true, false},
            {true, false, false, true},
            {true, false, false, true},
            {true, false, false, true},
            {false, true, true, false},
    };

    static boolean[][] ONE = {
            {false, false, true, false},
            {false, true, true, false},
            {false, false, true, false},
            {false, false, true, false},
            {false, true, true, true}
    };

    static boolean[][] TWO = {
            {true, true, true, false},
            {false, false, false, true},
            {false, true, true, false},
            {true, false, false, false},
            {true, true, true, true},
    };

    static boolean[][] THREE = {
            {true, true, true, false},
            {false, false, false, true},
            {false, true, true, false},
            {false, false, false, true},
            {true, true, true, false},
    };

    static boolean[][] FOUR = {
            {false, true, false, false},
            {true, false, false, true},
            {true, true, true, true},
            {false, false, false, true},
            {false, false, false, true},
    };

    static boolean[][] FIVE = {
            {true, true, true, true},
            {true, false, false, false},
            {true, true, true, false},
            {false, false, false, true},
            {true, true, true, false}
    };

    static boolean[][] SIX = {
            {false, true, true, false},
            {true, false, false, false},
            {true, true, true, false},
            {true, false, false, true},
            {false, true, true, false}
    };

    static boolean[][] SEVEN = {
            {true, true, true, true},
            {false, false, false, true},
            {false, false, true, false},
            {false, true, false, false},
            {false, true, false, false},
    };

    static boolean[][] EIGHT = {
            {false, true, true, false},
            {true, false, false, true},
            {false, true, true, false},
            {true, false, false, true},
            {false, true, true, false},
    };

    static boolean[][] NINE = {
            {false, true, true, false},
            {true, false, false, true},
            {false, true, true, true},
            {false, false, false, true},
            {false, true, true, false},
    };

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String digits = line.replaceAll("\\p{Punct}", "");

                List<boolean[][]> encodedDigits = new ArrayList<boolean[][]>();

                for (Character character : digits.toCharArray()) {
                    switch (character) {
                        case '0':
                            encodedDigits.add(ZERO);
                            break;
                        case '1':
                            encodedDigits.add(ONE);
                            break;
                        case '2':
                            encodedDigits.add(TWO);
                            break;
                        case '3':
                            encodedDigits.add(THREE);
                            break;
                        case '4':
                            encodedDigits.add(FOUR);
                            break;
                        case '5':
                            encodedDigits.add(FIVE);
                            break;
                        case '6':
                            encodedDigits.add(SIX);
                            break;
                        case '7':
                            encodedDigits.add(SEVEN);
                            break;
                        case '8':
                            encodedDigits.add(EIGHT);
                            break;
                        case '9':
                            encodedDigits.add(NINE);
                            break;
                    }
                }

                System.out.println(bigDigitizer(encodedDigits));
            }


        }
    }

    public static String bigDigitizer(List<boolean[][]> encodedDigits) {
        StringBuilder line = new StringBuilder();
        StringBuilder row0 = new StringBuilder();
        StringBuilder row1 = new StringBuilder();
        StringBuilder row2 = new StringBuilder();
        StringBuilder row3 = new StringBuilder();
        StringBuilder row4 = new StringBuilder();
        StringBuilder row5 = new StringBuilder();

        StringBuilder[] rowBuilders = new StringBuilder[]{row0, row1, row2, row3, row4};

        for (boolean[][] digit : encodedDigits) {
            int i = 0;
            for(StringBuilder row : rowBuilders){
                for(int j = 0; j < 4; j++){
                    row.append(digit[i][j] ? '*' : '-');
                }
                ++i;
                row5.append('-');

                row.append(false ? '*': '-');
            }
        }

        return line.append(row0.append("\n").toString()).append(row1.append("\n").toString()).append(row2.append("\n").toString()).append(row3.append("\n").toString()).append(row4.append("\n").toString()).append(row5.append("\n").toString()).toString();
    }

}
