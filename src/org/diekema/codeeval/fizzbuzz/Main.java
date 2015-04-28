package org.diekema.codeeval.fizzbuzz;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            File file = new File(args[0]);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parameters = line.split("\\s");

                Integer firstDivisor = new Integer(parameters[0]);
                Integer secondDivisor = new Integer(parameters[1]);
                Integer count = new Integer(parameters[2]);

                if ((firstDivisor > 0 && firstDivisor <= 20) && (secondDivisor > 0 && secondDivisor <= 20) && (count >= 21 && count <= 100)) {
                    System.out.println(fizzBuzz(firstDivisor, secondDivisor, count));
                }

            }
        }
    }

    public static String fizzBuzz(Integer firstDivisor, Integer secondDivisor, Integer count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            if (i % firstDivisor == 0) {
                stringBuilder.append("F");
            }

            if (i % secondDivisor == 0) {
                stringBuilder.append("B");
            }

            if (i % firstDivisor != 0 && i % secondDivisor != 0) {
                stringBuilder.append(i);
            }

            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }
}
