package org.diekema.codeeval.endianness;

import java.nio.ByteOrder;

/**
 * Created by rdiekema on 4/28/15.
 */
public class Main {

    public static void main(String[] args) {
        if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
            System.out.println("BigEndian");
        } else {
            System.out.println("LittleEndian");
        }
    }
}
