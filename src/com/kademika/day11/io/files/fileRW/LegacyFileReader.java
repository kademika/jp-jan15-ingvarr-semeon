package com.kademika.day11.io.files.fileRW;

import java.io.FileInputStream;
import java.io.IOException;

public class LegacyFileReader implements FileReader {

    @Override
    public String read(String fileName) {
        StringBuilder builder = new StringBuilder(); //A mutable sequence of characters
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(fileName);

            int i;
            while ((i = fis.read()) != -1) {
                builder.append((char) i); //The append method supplement String object with new chars
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
