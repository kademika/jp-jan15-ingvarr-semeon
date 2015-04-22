package com.kademika.day11.io.files.fileRW;

import java.io.FileInputStream;
import java.io.IOException;

public class DefaultFileReader implements FileReader {

    @Override
    public String read(String fileName) {
        StringBuilder builder = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(fileName)) {

            int i;
            while ((i = fis.read()) != -1) {
                builder.append((char) i); //Should use downcasting byte to char
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //fis will be closed automatically

        return builder.toString();
    }
}
