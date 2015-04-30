package org.diekema.codeeval.rightmostchar;

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
                if (line.trim().length() != 0) {
                    System.out.println(line.substring(0, line.lastIndexOf(',')).lastIndexOf(line.charAt(line.length()-1)));
                }
            }

            bufferedReader.close();
        }
    }
}
