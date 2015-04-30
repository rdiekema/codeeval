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
                    String string = line.split(",")[0];
                    Character character = line.split(",")[1].charAt(0);

                    boolean found = false;
                    for (int i = string.length() - 1; i > 0; i--) {
                        if (string.charAt(i) == character) {
                            System.out.println(i);
                            found = true;
                            break;
                        }
                    }

                    if(!found){
                        System.out.println(-1);
                    }
                }
            }
        }
    }
}
