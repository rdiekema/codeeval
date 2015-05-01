package org.diekema.codeeval.compressedsequence;

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
                String[] stringInts = line.split(" ");

                StringBuilder stringBuilder = new StringBuilder(512);
                int j = 1;
                for (int i = 0; i < stringInts.length; i++) {
                    int nextInt = i + 1 == stringInts.length ? i : i+1;

                    if (stringInts[i].equals(stringInts[nextInt]) && i != nextInt) {
                        j++;
                    } else {
                        stringBuilder.append(j).append(" ").append(stringInts[i]).append(" ");
                        j = 1;
                    }
                }
                System.out.println(stringBuilder.toString().trim());
            }
            bufferedReader.close();
        }
    }
}
