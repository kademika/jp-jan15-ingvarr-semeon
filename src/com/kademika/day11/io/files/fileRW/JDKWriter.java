package com.kademika.day11.io.files.fileRW;

import java.io.*;

public class JDKWriter implements FileWriter {

    @Override
    public void write(String data, String fileName) {

        try (
                //java.io.FileWriter fileWriter = new java.io.FileWriter(fileName)
                FileOutputStream fos = new FileOutputStream(fileName);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, "windows-1251")
        ) {
            //fileWriter.write(data);
            outputStreamWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
