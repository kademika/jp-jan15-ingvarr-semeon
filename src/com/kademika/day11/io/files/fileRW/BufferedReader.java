package com.kademika.day11.io.files.fileRW;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedReader implements FileReader {

    @Override
    public String read(String fileName) {
        StringBuilder builder = new StringBuilder();

        try (
                FileInputStream fis = new FileInputStream(fileName);
                BufferedInputStream bis = new BufferedInputStream(fis)
//                Whether the anonymous class instance "new FileInputStream(fileName)" will auto closed?
//                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        )
        {
            int i;
            while ((i = bis.read()) != -1) {
                builder.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
