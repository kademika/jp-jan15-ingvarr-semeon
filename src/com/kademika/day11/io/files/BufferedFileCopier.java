package com.kademika.day11.io.files;

import java.io.*;

public class BufferedFileCopier {

    public static void main(String[] args) throws IOException {
        File file = new File(getRelativeFileDir() + "StudyB.txt");

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

        try(/*FileReader reader = new FileReader(sourceFile)*/
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(sourceFile), 256)
        ) {
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

        try(/*FileWriter writer = new FileWriter(destinationFile)*/
            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(destinationFile))
        ) {
            writer.write(stringToBytes(builder.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] stringToBytes(String str) {
        char[] buffer = str.toCharArray();
        byte[] bytes = new byte[buffer.length];

        for (int i = 0; i < buffer.length; i++) {
            bytes[i] = (byte) buffer[i];
        }

        return bytes;
    }

    public static String getRelativeFileDir() {
        String path = "src/com/kademika/day11/io/files/";
        return path.replace("/", File.separator); //Separator depends on OS
    }
}
