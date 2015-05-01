package org.diekema.codeeval.setintersection;

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
                String[] set1 = line.substring(0, line.indexOf(';')).split(",");
                String[] set2 = line.substring(line.indexOf(';') + 1, line.length()).split(",");

                line = null;

                StringBuilder stringBuilder = new StringBuilder();
                for (String integer1 : set1) {
                    for (String integer2 : set2) {
                        if (integer1.equals(integer2)) {
                            stringBuilder.append(integer1).append(",");
                        }
                    }
                }
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                System.out.println(stringBuilder.toString());
            }
            bufferedReader.close();
        }
    }
}
