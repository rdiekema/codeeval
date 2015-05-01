package org.diekema.codeeval.bitpositions;

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
                String binaryString = Integer.toBinaryString(new Integer(line.split(",")[0]));
                int p1 = new Integer(line.split(",")[1]);
                int p2 = new Integer(line.split(",")[2]);

                System.out.println(binaryString.charAt(binaryString.length() - p1) == binaryString.charAt(binaryString.length() - p2));

            }
            bufferedReader.close();
        }
    }
}
