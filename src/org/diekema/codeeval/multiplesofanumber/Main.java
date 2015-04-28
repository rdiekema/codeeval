package org.diekema.codeeval.multiplesofanumber;

import java.io.*;

/**
 * Created by rdiekema on 4/27/15.
 */
public class Main {

    public static void main(String[] args) throws IOException{
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Integer number = Integer.valueOf(line.split(",")[0]);
                Integer powerOfTwo = Integer.valueOf(line.split(",")[1]);

                int i = powerOfTwo;
                while(!(i >= number)){
                    i += powerOfTwo;
                }

                System.out.println(i);
            }
        }
    }
}


