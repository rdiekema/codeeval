package org.diekema.codeeval.fibonacciseries;

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
                Integer n = new Integer(line);
                System.out.println(fibonacci(n));
            }
        }
    }

    public static int fibonacci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
