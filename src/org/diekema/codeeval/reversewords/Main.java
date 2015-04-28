package org.diekema.codeeval.reversewords;

import java.io.*;

/**
 * Created by rdiekema on 4/27/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().length() > 0) {
                    String[] words = line.split("\\s");

                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = words.length-1; i >= 0; i--) {
                        stringBuilder.append(words[i]).append(" ");
                    }

                    System.out.println(stringBuilder.toString().trim());
                }
            }
        }
    }
}
