package com.kademika.day11.io.zip;

import java.io.*;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipArchivator {

    public static void main(String[] args) {
        zip(new File(getRelativeFileDir() + "testFile.txt")); //Single file
        zip(new File(getRelativeFileDir() + "testFiles")); //Folder with files and subfolders

//        unZip(new File(getRelativeFileDir() + "testFile.zip"));
//        unZip(new File(getRelativeFileDir() + "testFiles.zip"));
    }

    public static void zip(File inputFile) {
        ZipOutputStream zipOutputStream = null;

        try {
            if (inputFile.isFile()) {
                String zipFilePath = inputFile.getPath().substring(0, inputFile.getPath().indexOf('.')) + ".zip";
                zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath));
                zipOutputStream.setLevel(Deflater.DEFAULT_COMPRESSION); //Setup compression level
                addFileToZip(inputFile, zipOutputStream, "", zipFilePath);
            } else if (inputFile.isDirectory()) {
                String zipFilePath = inputFile.getPath() + ".zip";
                zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath));
                zipOutputStream.setLevel(Deflater.BEST_COMPRESSION); //Setup compression level
                addFolderToZip(inputFile, zipOutputStream, "", zipFilePath);

                zipOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addFileToZip(File inputFile, ZipOutputStream zipOutputStream, String parentName, String zipFilePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);

        ZipEntry zipEntry = new ZipEntry(parentName + inputFile.getName());
        zipEntry.setMethod(ZipEntry.DEFLATED); //file compressing
        zipOutputStream.putNextEntry(zipEntry);

        byte[] buffer = new byte[1024]; //[fileInputStream.available()]; ???
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) > 0) { // != -1 ???
            zipOutputStream.write(buffer, 0, bytesRead);
        }
        zipOutputStream.closeEntry();

        System.out.println("File: " + parentName + inputFile.getName() + " is zipped to archive: " + zipFilePath);
    }

    private static void addFolderToZip(File inputFolder, ZipOutputStream zipOutputStream, String parentName, String zipFilePath) throws IOException {
        System.out.println(parentName + inputFolder.getName() + File.separator);

        String folderName = parentName + inputFolder.getName() + File.separator;

        ZipEntry folderZipEntry = new ZipEntry(folderName);
        zipOutputStream.putNextEntry(folderZipEntry);

        File[] cotents = inputFolder.listFiles();
        for (File f : cotents) {
            if (f.isFile()) {
                addFileToZip(f, zipOutputStream, folderName, zipFilePath);
            } else if (f.isDirectory()) {
                addFolderToZip(f, zipOutputStream, folderName, zipFilePath);
            }
        }
        zipOutputStream.closeEntry();
    }

    public static void unZip(File inputFile) {
        File destinationFolder = new File(inputFile.getPath().substring(0, inputFile.getPath().indexOf('.')));
        System.out.println(destinationFolder);

        if(!destinationFolder.exists()) {
            destinationFolder.mkdir();
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(inputFile)))
        {
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                File file = new File(destinationFolder + File.separator + zipEntry.getName());
                System.out.println("File " + zipEntry.getName() + " unzipped to " + file.getPath());

                if(zipEntry.isDirectory()) {
                    File newDir = new File(file.getAbsolutePath());
                    if(!newDir.exists()) {
                        newDir.mkdir();
                    }
                } else {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] buffer = new byte[1024]; //[fileInputStream.available()]; ???
                    int bytesRead;
                    while ((bytesRead = zipInputStream.read(buffer)) > 0) { // != -1 ???
                        fileOutputStream.write(buffer, 0, bytesRead);
                    }
                    fileOutputStream.close();
                }
                zipInputStream.closeEntry();
                zipEntry = zipInputStream.getNextEntry();
            }
            zipInputStream.closeEntry(); //close last entry
        } catch (IOException e) {
            e.printStackTrace();
        }
        //zipInputStream.close(); // will be closed automaticaly
        //anonymous FileInputStream also will be closed automaticaly
    }

    private static String getRelativeFileDir() {
        String path = "src/com/kademika/day11/io/zip/";

        return path.replace("/", File.separator); //Separator depends on OS
    }
}