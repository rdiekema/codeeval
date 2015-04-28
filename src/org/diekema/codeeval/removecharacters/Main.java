package org.diekema.codeeval.removecharacters;

import java.io.*;

/**
 * Created by rdiekema on 4/28/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String text = line.split(",")[0];
                String replaceChars = line.split(",")[1].trim();

                System.out.println(text.replaceAll("[" + replaceChars +"]", ""));
            }
        }
    }
}

