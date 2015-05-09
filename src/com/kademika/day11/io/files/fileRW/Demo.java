package com.kademika.day11.io.files.fileRW;

public class Demo {

    public static void main(String[] args) {
        String fileName = "src//com//kademika//day11//io//files//fileRW//data.txt";

        FileWriter writer = new LegacyFileWriter();
        writer.write("I love programming !", fileName);

        FileReader reader = new LegacyFileReader();
        System.out.println(reader.read(fileName));

        writer = new DefaultFileWriter();
        writer.write("Me too :)", fileName);

        reader = new DefaultFileReader();
        System.out.println(reader.read(fileName));

        reader = new BufferedReader256();
        System.out.println(reader.read(fileName));

//        writer = new JDKWriter();
//        writer.write("Я люблю програмування ї", fileName);
//
//        reader = new JDKReader();
//        System.out.println(reader.read(fileName));
    }
}
