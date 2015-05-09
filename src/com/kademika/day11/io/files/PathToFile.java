package com.kademika.day11.io.files;

import java.io.File;

public class PathToFile {

    public static void main(String[] args) {

        File file = new File("test.txt");

        System.out.println(System.getProperty("user.dir"));
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
        for (File f : file.listRoots()) {
            System.out.println(f.getAbsolutePath());
        }

        System.out.println(getRelativeFileDir());
        System.out.println(getFilePath());
    }

    public static String getRelativeFileDir() {
        String path = "src/com/kademika/day11/io/files";
        return path.replace("/", File.separator); //Separator depends on OS
    }

    public static String getFilePath() {
        String path = "src/com/kademika/day11/io/files";
        path.replace("/", File.separator);

        File thisFile = new File(path, PathToFile.class.getSimpleName() + ".java");

        return  thisFile.getAbsolutePath();
    }
}
