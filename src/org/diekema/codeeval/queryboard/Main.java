package org.diekema.codeeval.queryboard;

import java.io.*;

/**
 * Created by rdiekema on 4/29/15.
 */
public class Main {
    /*
    SetRow i x: it means that all values in the cells on row "i" have been changed to value "x" after this operation.
    SetCol j x: it means that all values in the cells on column "j" have been changed to value "x" after this operation.
    QueryRow i: it means that you should output the sum of values on row "i".
    QueryCol j: it means that you should output the sum of values on column "j".
     */

    static final String SET_ROW = "SetRow";
    static final String SET_COL = "SetCol";
    static final String QUERY_ROW = "QueryRow";
    static final String QUERY_COL = "QueryCol";

    static int M = 256;
    static int N = 256;

    static int[][] matrix = new int[256][256];

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] commandArgumentValue = line.split(" ");
                String command = commandArgumentValue[0];
                Integer argument = Integer.valueOf(commandArgumentValue[1]);
                Integer value = null;
                if (commandArgumentValue.length == 3) {
                    value = Integer.valueOf(commandArgumentValue[2]);
                }

                switch (command) {
                    case SET_ROW:
                        setRow(argument, value);
                        break;
                    case SET_COL:
                        setCol(argument, value);
                        break;
                    case QUERY_ROW:
                        System.out.println(queryRow(argument));
                        break;
                    case QUERY_COL:
                        System.out.println(queryCol(argument));
                        break;
                }
            }
        }
    }

    static void setRow(int i, int value) {
        for (int j = 0; j < M; j++) {
            matrix[i][j] = value;
        }
    }

    static void setCol(int j, int value) {
        for (int i = 0; i < N; i++) {
            matrix[i][j] = value;
        }
    }

    static int queryRow(int i) {
        int total = 0;

        for (int j = 0; j < M; j++) {
            total += matrix[i][j];
        }

        return total;
    }

    static int queryCol(int j) {
        int total = 0;

        for (int i = 0; i < M; i++) {
            total += matrix[i][j];
        }

        return total;
    }
}
