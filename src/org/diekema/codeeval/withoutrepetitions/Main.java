package org.diekema.codeeval.withoutrepetitions;

import java.io.*;

/**
 * Created by rdiekema on 4/29/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringBuilder stringBuilder = new StringBuilder(512);
                int j = 1;
                for (int i = 0; i < line.length(); i++) {
                    int nextChar = i + 1 == line.length() ? i : i + 1;

                    // If the current character is not equal to the next character, it's not a duplicate.
                    if(line.charAt(i) != line.charAt(nextChar) || i == nextChar){
                        stringBuilder.append(line.charAt(i));
                    }
                }
                System.out.println(stringBuilder.toString().trim());
            }
            bufferedReader.close();
        }
    }
}
