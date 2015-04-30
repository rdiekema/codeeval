package org.diekema.codeeval.readmore;

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
                if(line.length() > 55){
                    line = line.substring(0, 40);
                    line = line.substring(0, line.lastIndexOf(' ') == -1 ? line.length() : line.lastIndexOf(' '));
                    line = line.trim() + "... <Read More>";
                }

                System.out.println(line);
            }
            bufferedReader.close();
        }
    }
}
