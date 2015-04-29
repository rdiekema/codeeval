package org.diekema.codeeval.rollercoaster;

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
                line = line.toUpperCase();

                int i = 0;
                for (char character : line.toCharArray()) {
                        if (character >= 65 && character <= 90) {
                            if (i % 2 != 0) {
                                stringBuilder.append((char) (character + 32));
                            }
                            else{
                                stringBuilder.append(character);
                            }
                            i++;
                    } else {
                        stringBuilder.append(character);
                    }
                }

                stringBuilder.append("\n");
            }

            System.out.println(stringBuilder.toString());
        }
    }
}
