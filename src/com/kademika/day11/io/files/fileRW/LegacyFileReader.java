package com.kademika.day11.io.files.fileRW;

import java.io.FileInputStream;
import java.io.IOException;

public class LegacyFileReader implements FileReader {

    @Override
    public String read(String fileName) {
        //StringBuilder is the String wrapper which is used for appending of String object
        StringBuilder builder = new StringBuilder();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(fileName);

            int i;
            while ((i = fis.read()) != -1) {
                builder.append((char) i); //Should use downcasting byte to char
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    //ignore
                }
            }
        }

        return builder.toString();
    }
}
