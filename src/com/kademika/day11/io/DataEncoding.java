package com.kademika.day11.io;

import com.kademika.day11.io.files.fileRW.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class DataEncoding {

    public static void main(String[] args) {
        String path = "src/com/kademika/day11/io/files/fileRW";
        File file = new File(path.replace("/", File.separator), "data.txt");

        changeEncoding(file, String.valueOf(StandardCharsets.ISO_8859_1), String.valueOf(StandardCharsets.US_ASCII));

        com.kademika.day11.io.files.fileRW.FileReader reader = new DefaultFileReader();
        System.out.println(reader.read(file.getName()));
        System.out.println("Done");
    }

    public static void changeEncoding(File file, String currentEncoding, String neededEncoding) {
        String fileName = file.getName();
        StringBuilder builder = new StringBuilder();

        try (
                FileInputStream fis = new FileInputStream(fileName);
                InputStreamReader reader = new InputStreamReader(fis, currentEncoding);
                java.io.BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                builder.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, neededEncoding)
        ) {
            outputStreamWriter.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
