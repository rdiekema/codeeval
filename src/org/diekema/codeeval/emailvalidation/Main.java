package org.diekema.codeeval.emailvalidation;

import java.io.*;
import java.util.regex.Pattern;

/**
 * Created by rdiekema on 4/28/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Pattern email = Pattern.compile("[\\w\\+\\.\\-%_]+@[\\w\\.]+\\.\\w+");

//                System.out.println(line);

                if(email.matcher(line).matches()){
                    System.out.println("true");
                }
                else{
                    System.out.println("false");
                }
            }
        }
    }
}
