package ru.java.courses;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WorkingWithFilesSymbol {

    public static void main(String[] args) {
        copy();
    }


    public static void copy() {
        File inputFile = new File("files/input.txt");
        File outputFile = new File("files/output.txt");

        if (inputFile.isDirectory() || !inputFile.exists()) {
            throw new RuntimeException("File not found");
        }

        if (outputFile.isDirectory()) {
            throw new RuntimeException("Invalid path to file");
        }

        if (outputFile.exists()) {
            boolean deleted = outputFile.delete();
            if(!deleted){
                throw new RuntimeException("Can't remove file" + outputFile.getAbsolutePath());
            }
                    }

        try (
                FileReader fis = new FileReader(inputFile);
                BufferedReader bis = new BufferedReader(fis);

                FileWriter fos = new FileWriter(outputFile);
                BufferedWriter bos = new BufferedWriter(fos)
        ) {


           String cbuf = new String();

            while((cbuf = bis.readLine())!=null) {
                bos.write(cbuf);
            }

            bos.flush();

         //  bis.close(); // закрываем поток
          //  bos.close();

        } catch (IOException e) {
            // shit happens
        }


    }


}
