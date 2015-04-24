package com.kademika.day11.io.files;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesPrinter {

    public static void main(String[] args) throws IOException {
        byte[] fileArray = Files.readAllBytes(Paths.get(getRelativeFileDir() + "FilesPrinter.java"));

        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(fileArray);

        printStreamData(byteInputStream);
    }

    public static void printStreamData(InputStream inputStream) throws IOException {
        int b;
        System.out.println("File printing:");
        while ((b = inputStream.read()) != -1) {
            System.out.print((char) b);
        }
        System.out.println();
    }

    public static String getRelativeFileDir() {
        String path = "src/com/kademika/day11/io/files/";
        return path.replace("/", File.separator); //Separator depends on OS
    }

}
