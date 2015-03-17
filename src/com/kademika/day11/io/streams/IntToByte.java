package com.kademika.day11.io.streams;

public class IntToByte {

    public static void main(String[] args) {
        int LEN = 300;
        int[] array = new int[LEN];

        for (int i = 0; i < LEN; i++) {
            array[i] = i;
        }

        for (int i = 0; i < LEN - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[LEN - 1]);

        System.out.println();

        for (int i = 0; i < LEN - 1; i++) {
            System.out.print((byte) array[i] + ", ");
        }
        System.out.println((byte) array[LEN - 1]);
    }
}
