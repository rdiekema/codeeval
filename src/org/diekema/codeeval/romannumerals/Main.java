package org.diekema.codeeval.romannumerals;

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
                Integer integer = Integer.valueOf(line);
                line = null;

                StringBuilder stringBuilder = new StringBuilder();
                while (integer > 0) {
                    if (integer >= 1000) {
                        stringBuilder.append('M');
                        integer -= 1000;
                    } else if (integer > 899 && integer < 1000) {
                        stringBuilder.append('C').append('M');
                        integer -= 900;
                    } else if (integer >= 500) {
                        stringBuilder.append('D');
                        integer -= 500;
                    } else if(integer > 399 && integer < 500){
                        stringBuilder.append('C').append('D');
                        integer -= 400;
                    } else if (integer >= 100) {
                        stringBuilder.append('C');
                        integer -= 100;
                    } else if (integer > 89 && integer < 100) {
                        stringBuilder.append('X').append('C');
                        integer -= 90;
                    } else if (integer >= 50) {
                        stringBuilder.append('L');
                        integer -= 50;
                    } else if(integer > 39 && integer < 50){
                        stringBuilder.append('X').append('L');
                        integer -= 40;
                    } else if (integer >= 10) {
                        stringBuilder.append('X');
                        integer -= 10;
                    } else if (integer == 9) {
                        stringBuilder.append('I').append('X');
                        integer -= 9;
                    } else if (integer >= 5) {
                        stringBuilder.append('V');
                        integer -= 5;
                    } else if (integer == 4) {
                        stringBuilder.append('I').append('V');
                        integer -= 4;
                    } else if (integer > 0) {
                        stringBuilder.append('I');
                        integer -= 1;
                    }
                }

                System.out.println(stringBuilder.toString());
            }

            bufferedReader.close();
        }
    }
}
