package org.diekema.codeeval.oddnumbers;

/**
 * Created by rdiekema on 4/27/15.
 */
public class Main {

    public static void main(String[] args){
        for(int i = 1; i < 100; i++){
            if(i % 2 != 0){
                System.out.println(i);
            }
        }
    }
}
