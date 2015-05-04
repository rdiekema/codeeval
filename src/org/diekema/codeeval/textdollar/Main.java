package org.diekema.codeeval.textdollar;

import java.io.*;
import java.util.Stack;

/**
 * Created by rdiekema on 5/2/15.
 */
public class Main {

    static String ONE = "One";
    static String TWO = "Two";
    static String THREE = "Three";
    static String FOUR = "Four";
    static String FIVE = "Five";
    static String SIX = "Six";
    static String SEVEN = "Seven";
    static String EIGHT = "Eight";
    static String NINE = "Nine";
    static String TEN = "Ten";
    static String ELEVEN = "Eleven";
    static String TWELVE = "Twelve";
    static String THIRTEEN = "Thirteen";
    static String FOURTEEN = "Fourteen";
    static String FIFTEEN = "Fifteen";
    static String SIXTEEN = "Sixteen";
    static String SEVENTEEN = "Seventeen";
    static String EIGHTEEN = "Eighteen";
    static String NINETEEN = "Nineteen";

    static String[] ones = {null, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN, EIGHTEEN, NINETEEN};

    static String TWENTY = "Twenty";
    static String THIRTY = "Thirty";
    static String FORTY = "Forty";
    static String FIFTY = "Fifty";
    static String SIXTY = "Sixty";
    static String SEVENTY = "Seventy";
    static String EIGHTY = "Eighty";
    static String NINETY = "Ninety";

    static String[] tens = {null, null, TWENTY, THIRTY, FORTY, FIFTY, SIXTY, SEVENTY, EIGHTY, NINETY};

    static String HUNDRED = "Hundred";
    static String THOUSAND = "Thousand";
    static String MILLION = "Million";

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(count(line));
            }

            bufferedReader.close();
        }
    }

    public static String count(String digits) {
        StringBuilder stringBuilder = new StringBuilder();

        Stack<Character> characterStack = new Stack<>();

        char[] digitArray = digits.toCharArray();
        int magnitude = digitArray.length;
        for (int i = digitArray.length - 1; i >= 0; i--) {
            characterStack.push(digitArray[i]);
        }

        while (!characterStack.isEmpty() && magnitude > 0) {
            int characterStackSize = characterStack.size();

            if (characterStackSize % 3 == 0) {
                if (ones[characterStack.peek() - 48] != null) {
                    stringBuilder.append(ones[characterStack.pop() - 48]);
                    stringBuilder.append(HUNDRED);
                } else {
                    characterStack.pop();
                }
            } else if (characterStackSize == 8 || characterStackSize == 5 || characterStackSize == 2) {
                if (characterStack.peek() - 48 == 1) {
                    characterStack.pop();
                    stringBuilder.append(ones[10 + characterStack.pop() - 48]);
                    magnitude--;
                } else {
                    if (tens[characterStack.peek() - 48] != null) {
                        stringBuilder.append(tens[characterStack.pop() - 48]);
                    } else {
                        characterStack.pop();
                    }
                }
            } else {
                if (ones[characterStack.peek() - 48] != null) {
                    stringBuilder.append(ones[characterStack.pop() - 48]);
                } else {
                    characterStack.pop();
                }
            }

            magnitude--;

            if (magnitude == 6) {
                stringBuilder.append(MILLION);

                while (!characterStack.isEmpty() && characterStack.peek() - 48 == 0) {
                    characterStack.pop();
                    magnitude--;
                }
            } else if (magnitude == 3) {
                stringBuilder.append(THOUSAND);
            }
        }

        if (stringBuilder.length() != 0) {
            stringBuilder.append("Dollars");
        }

        return stringBuilder.toString();
    }

}