package org.diekema.codeeval.nmodm;

import java.io.*;

/**
 * Created by rdiekema on 5/1/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Integer n = Integer.valueOf(line.substring(0, line.indexOf(',')));
                Integer m = Integer.valueOf(line.substring(line.indexOf(',') + 1, line.length()));

                // a mod b = a - (a / b) * b
                int mod = m > n ? n : n - (n / m) * m;

                System.out.println(mod);
            }

            bufferedReader.close();
        }
    }
}
