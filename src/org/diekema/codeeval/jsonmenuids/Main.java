package org.diekema.codeeval.jsonmenuids;


import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by rdiekema on 4/29/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

            Pattern pattern = Pattern.compile("\"label\":\\s\"[\\w\\d\\s]+\"");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().length() > 0) {
                    Scanner scanner = new Scanner(line);

                    String scanLine;
                    Integer total = 0;
                    while ((scanLine = scanner.findInLine(pattern)) != null) {
                        String splitLine = scanLine.split(":")[1].trim().split(" ")[1].replace("\"", "");
                        total += Integer.valueOf(splitLine);
                    }

                    System.out.println(total);
                }
            }
            bufferedReader.close();
        }
    }
}
