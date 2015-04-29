package org.diekema.codeeval.armstrongnumbers;

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

                Double total = 0d;
                for(Character character : line.toCharArray()){
                    total += Math.pow(Integer.valueOf(String.valueOf(character)), line.toCharArray().length);
                }

                System.out.println(total.equals(Double.valueOf(line)) ? "True" : "False");
            }
        }
    }
}
