package org.diekema.codeeval.swapcase;

import java.io.*;

/**
 * Created by rdiekema on 4/29/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for(char character : line.toCharArray()){
                    if(character > 64 && character < 91){
                        //uppercase
                        character = (char) (character + 32);
                    }
                    else if(character > 96 && character < 123){
                        // is lowercase
                        character = (char) (character - 32);
                    }

                    stringBuilder.append(character);
                }

                System.out.println(stringBuilder.toString());
            }

            bufferedReader.close();
        }
    }
}
