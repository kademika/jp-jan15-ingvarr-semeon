package com.kademika.day11.io.files.fileRW;

public class Demo {

    public static void main(String[] args) {
        String fileName = "src//com//kademika//day11//io//files//fileRW//data.txt";

        FileWriter writer = new LegacyFileWriter();
        writer.write("I love programming", fileName);

        FileReader reader = new LegacyFileReader();
        System.out.println(reader.read(fileName));

        writer = new DefaultFileWriter();
        writer.write("Me too :)", fileName);

        reader = new DefaultFileReader();
        System.out.println(reader.read(fileName));

        reader = new BufferedReader();
        System.out.println(reader.read(fileName));
    }
}
