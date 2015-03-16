package com.kademika.day11.io;

import java.io.File;
import java.io.IOException;

public class FileCreator {

    public static void main(String[] args) throws IOException {
        File dir1 = new File(getRelativeFileDir() + "dir1");
        if (dir1.mkdir()) {
            System.out.println("Directory " + dir1.getName() + " was created");
        } else {
            System.out.println("Directory " + dir1.getName() + " creation was failed");
        }

        File subDirs = new File(getRelativeFileDir() + "dirA\\dirB\\dirC");
        if (subDirs.mkdirs()) {
            System.out.println("Directory " + subDirs.getName() + " was created");
        } else {
            System.out.println("Directory " + subDirs.getName() + " creation was failed");
        }

        File file1 = new File(dir1, "file1.txt");
        if (file1.createNewFile()) {
            System.out.println("File " + file1.getName() + " was created");
        } else {
            System.out.println("File " + file1.getName() + " creation was failed");
        }

        System.out.println("System Property:");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("os.version"));
    }

    public static String getRelativeFileDir() {
        String path = "src/com/kademika/day11/io/";
        return path.replace("/", File.separator); //Separator depends on OS
    }
}
