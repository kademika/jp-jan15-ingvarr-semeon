package com.kademika.day11.javaIO;

public class intToByte {

    public static void main(String[] args) {
        int LEN = 300;
        int[] array = new int[LEN];

        for (int i = 0; i < LEN; i++) {
            array[i] = i;
        }

        for (int i = 0; i < LEN - 1; i++) {
            System.out.print((byte) array[i] + ", ");
        }
        System.out.println((byte) array[LEN - 1]);
    }
}
