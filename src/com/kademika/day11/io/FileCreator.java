package com.kademika.day11.io;

import java.io.File;

public class FileCreator {

    public static void main(String[] args) {
        File dir1 = new File(getRelativeFileDir() + "dir1");
    }

    public static String getRelativeFileDir() {
        String path = "src/com/kademika/day11/io";
        return path.replace("/", File.separator); //Separator depends on OS
    }
}
