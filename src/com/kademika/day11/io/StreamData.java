package com.kademika.day11.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class StreamData {

    public static void main(String[] args) throws IOException {

        ByteArrayOutputStream bOutputStream = new ByteArrayOutputStream(10);

        System.out.print("Please input 10 characters: ");
        while (bOutputStream.size() != 10) {
            bOutputStream.write(System.in.read());
        }
        System.out.println("The stream has been read.");

        byte[] bytes = bOutputStream.toByteArray();

        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
        printStreamData(byteInputStream);
    }

    public static void printStreamData(ByteArrayInputStream inputStream) {
        int b;
        System.out.println("Stream printing:");
        while ((b = inputStream.read()) != -1) {
            System.out.println((char)b);
        }
    }
}
