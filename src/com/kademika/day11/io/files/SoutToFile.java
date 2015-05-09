package com.kademika.day11.io.files;

import java.io.*;

public class SoutToFile {

    public static void main(String[] args) {
        File file = new File(getRelativeFileDir(), "fileOut.txt");
        PrintStream printStream = null;
        PrintStream console = System.out;

        try (FileOutputStream fos = new FileOutputStream(file)) {
            printStream = new PrintStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setOut(printStream);
        System.out.println("First line in file.");

        System.setOut(console);
        System.out.println("First line in console...");

        System.setOut(printStream);
        System.out.println("Second line in file.");

        //Why do not work next code ???
        //System.setOut(console);
        //System.out.print("Second line in console");
        //System.out.println("...");

    }

    public static String getRelativeFileDir() {
        String path = "src/com/kademika/day11/io/files/";
        return path.replace("/", File.separator); //Separator depends on OS
    }
}
