package org.diekema.codeeval.lowercase;

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
                System.out.println(line.toLowerCase());
            }
            bufferedReader.close();
        }
    }
}
