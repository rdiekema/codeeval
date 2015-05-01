package org.diekema.codeeval.hiddendigits;

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
                StringBuilder stringBuilder = new StringBuilder();
                for(char c : line.toCharArray()){
                    if(c >= 48 && c <=57){
                       stringBuilder.append(c);
                    } else if(c >= 97 && c <=106){
                        stringBuilder.append((char)(c-49));
                    }
                }

                if(stringBuilder.length() != 0) {
                    System.out.println(stringBuilder.toString());
                }else{
                    System.out.println("NONE");
                }
            }
            bufferedReader.close();
        }
    }
}
