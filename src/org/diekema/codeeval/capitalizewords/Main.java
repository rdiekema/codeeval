package org.diekema.codeeval.capitalizewords;

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
                char[] lineCharArray = line.toCharArray();
                for (int i = 0; i < lineCharArray.length; i++) {
                    if (lineCharArray[i] >= 97 && lineCharArray[i] <= 122) {
                        if (i == 0 || (i > 0 && lineCharArray[i - 1] == ' ')){
                            lineCharArray[i] = (char) (lineCharArray[i] - 32);
                        }
                    }
                }
                System.out.println(lineCharArray);
            }
        }
    }
}
