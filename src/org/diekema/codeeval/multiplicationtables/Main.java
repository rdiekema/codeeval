package org.diekema.codeeval.multiplicationtables;

/**
 * Created by rdiekema on 4/27/15.
 */
public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 1; j <= 12; j++) {
                String value = Integer.toString(i * j);

                while(value.length() < 4){
                    value = " " + value;
                }

                row.append(value);

            }

            System.out.println(row.toString());
        }
    }
}
