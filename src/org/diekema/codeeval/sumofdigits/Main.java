package org.diekema.codeeval.sumofdigits;

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
                Integer sum = 0;
                for(char a : line.toCharArray()){
                    sum += a-48;
                }
                System.out.println(sum);
            }
        }
    }
}
