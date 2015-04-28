package org.diekema.codeeval.details;

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
                String[] rows = line.split(",");

                int minDistance = 0;
                int i = 0;
                for (String row : rows) {
                    int j = 0;
                    for (char character : row.toCharArray()) {
                        if (character == 89) {
                            break;
                        }

                        if (character == 46) {
                            j++;
                        }
                    }

                    if (i == 0) {
                        minDistance = j;
                    } else if (j < minDistance) {
                        minDistance = j;
                    }

                    i++;
                }
                System.out.println(minDistance);
            }
        }
    }
}

