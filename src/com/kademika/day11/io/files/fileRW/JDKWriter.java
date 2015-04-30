package com.kademika.day11.io.files.fileRW;

import java.io.*;

public class JDKWriter implements FileWriter {

    @Override
    public void write(String data, String fileName) {

        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, "windows-1251")
        ) {
            outputStreamWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
