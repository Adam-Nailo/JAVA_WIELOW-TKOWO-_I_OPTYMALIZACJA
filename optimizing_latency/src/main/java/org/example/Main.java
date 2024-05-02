package org.example;

public class Main {
    private static PathManager pathManager = new PathManager();

    public static void main(String[] args) {

        String fileName = "data1.txt";

        String absolutePath = pathManager.createAbsoluteResourceFilePath(fileName);

        System.out.println(absolutePath);
    }
}