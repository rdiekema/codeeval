package org.diekema.codeeval.sumofintegersfromfile;

import java.io.*;

/**
 * Created by rdiekema on 4/27/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            Integer total = 0;
            while ((line = bufferedReader.readLine()) != null) {
                total += Integer.parseInt(line);
            }

            System.out.println(total);
        }
    }
}
