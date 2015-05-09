package com.kademika.day11.io.files;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipArchivator {

    public static void main(String[] args) {
        //zip(new File(getRelativeFileDir() + "testFile.txt"));
        zip(new File(getRelativeFileDir() + "testFiles"));
    }

    public static void zip(File inputFile) {

        try {
            if (inputFile.isFile()) {
                String zipFilePath = inputFile.getPath().substring(0, inputFile.getPath().indexOf('.')) + ".zip";
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath));
                addFileToZip(inputFile, zipOutputStream, zipFilePath);
            } else if (inputFile.isDirectory()) {
                String zipFilePath = inputFile.getPath() + ".zip";
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath));
                addFolderToZip(inputFile, zipOutputStream, zipFilePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //zipOutputStream.close(); //Will be auto closed or no???
    }

    public static void addFileToZip(File inputFile, ZipOutputStream zipOutputStream, String zipFilePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);

        ZipEntry zipEntry = new ZipEntry(inputFile.getName());
        zipEntry.setMethod(ZipEntry.DEFLATED); //file compressing
        zipOutputStream.putNextEntry(zipEntry);

        byte[] buffer = new byte[1024]; //[fileInputStream.available()];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) > 0) { // != -1 ???
            zipOutputStream.write(buffer, 0, bytesRead);
        }
        zipOutputStream.closeEntry();

        System.out.println("File: " + inputFile + " is zipped to archive: " + zipFilePath);
    }

    public static void addFolderToZip(File inputFolder, ZipOutputStream zipOutputStream, String zipFilePath) throws IOException {
        String zipFilePathAdd = zipFilePath;

        ZipEntry folderZipEntry = new ZipEntry(zipFilePathAdd);
        zipOutputStream.putNextEntry(folderZipEntry);

        File[] cotents = inputFolder.listFiles();
        for (File f : cotents) {
            if (f.isFile()) {
                addFileToZip(f, zipOutputStream, zipFilePathAdd);
            } else if (f.isDirectory()) {
                addFolderToZip(f, zipOutputStream, zipFilePathAdd);
            }
        }
        zipOutputStream.closeEntry();
    }

    public static void unZipFile(File inputFile, String unzipFilePath) {

    }

    public static String getRelativeFileDir() {
        String path = "src/com/kademika/day11/io/files/";
        return path.replace("/", File.separator); //Separator depends on OS
    }
}