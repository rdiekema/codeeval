package org.diekema.codeeval.filesize;

import java.io.*;

/**
 * Created by rdiekema on 4/27/15.
 */
public class Main {

    public static void main(String[] args) throws IOException{
        if (args.length > 0) {
            System.out.println(new File(args[0]).length());
        }
    }
}
