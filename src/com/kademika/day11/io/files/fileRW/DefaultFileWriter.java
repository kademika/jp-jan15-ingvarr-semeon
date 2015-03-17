package com.kademika.day11.io.files.fileRW;

import java.io.*;

public class DefaultFileWriter extends java.io.FileWriter {

    public DefaultFileWriter(String fileName) throws IOException {
        super(fileName);
    }
}
