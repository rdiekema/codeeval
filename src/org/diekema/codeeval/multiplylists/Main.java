package org.diekema.codeeval.multiplylists;

import java.io.*;

/**
 * Created by rdiekema on 4/28/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] set1 = line.split("\\|")[0].trim().split(" ");
                String[] set2 = line.split("\\|")[1].trim().split(" ");

                for(int i = 0; i < set1.length; i++){
                    stringBuilder.append(Integer.valueOf(set1[i]) * Integer.valueOf(set2[i])).append(" ");
                }

                stringBuilder.append("\n");
            }
            bufferedReader.close();
            System.out.println(stringBuilder.toString().trim());
        }
    }
}
