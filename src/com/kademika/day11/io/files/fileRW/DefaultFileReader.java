package com.kademika.day11.io.files.fileRW;

import java.io.*;

public class DefaultFileReader extends java.io.FileReader {

    public DefaultFileReader(String fileName) throws FileNotFoundException {
        super(fileName);
    }
}
