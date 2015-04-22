package com.kademika.day11.io.files;

import java.io.*;

public class FileCopier {

    public static void main(String[] args) throws IOException {
        File file = new File(getRelativeFileDir() + "TestFile.txt");

        try(FileWriter writer = new FileWriter(file)) {
            writer.write("I study how to work with files and directories in Java");
            writer.append('!');
        } catch (IOException e) {
            e.printStackTrace();
        }

        copyFile(file);
    }

    public static void copyFile(File sourceFile) throws IOException {
        StringBuilder builder = new StringBuilder();

        try(FileReader reader = new FileReader(sourceFile)) {
            int c;
            while ((c=reader.read()) != -1) {
                builder.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File destinationFile = new File(getRelativeFileDir()
                + sourceFile.getName().substring(0, sourceFile.getName().indexOf('.'))
                + "Copy" + sourceFile.getName().substring(sourceFile.getName().indexOf('.')));

        try(FileWriter writer = new FileWriter(destinationFile)) {
            writer.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRelativeFileDir() {
        String path = "src/com/kademika/day11/io/files/";
        return path.replace("/", File.separator); //Separator depends on OS
    }
}
