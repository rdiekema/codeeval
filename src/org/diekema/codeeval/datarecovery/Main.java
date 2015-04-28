package org.diekema.codeeval.datarecovery;

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
                String[] words = line.split(";")[0].split(" ");
                String[] order = line.split(";")[1].split(" ");
                String[] recovered = new String[words.length];

                for (int i = 0; i < words.length; i++) {
                    if (i == order.length) {
                        for (int j = 0; j < recovered.length; j++) {
                            if (recovered[j] == null) {
                                recovered[j] = words[words.length - 1];
                            }
                        }

                        continue;
                    }

                    recovered[Integer.valueOf(order[i]) - 1] = words[i];
                }

                StringBuilder stringBuilder = new StringBuilder();
                for (String word : recovered) {
                    stringBuilder.append(word).append(" ");
                }

                System.out.println(stringBuilder.toString().trim());
            }
        }
    }
}
