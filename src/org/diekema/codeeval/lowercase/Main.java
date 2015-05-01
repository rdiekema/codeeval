package org.diekema.codeeval.lowercase;

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
                StringBuilder stringBuilder = new StringBuilder();
                for(char character : line.toCharArray()){
                    if(character >=65 && character <= 90){
                        character = (char)(character +32);
                    }
                    stringBuilder.append(character);
                }
                System.out.println(stringBuilder.toString());
            }
            bufferedReader.close();
        }
    }
}
