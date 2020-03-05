package com.company;

public class Main {

    public static void main(String[] args) {

        TestRun();
    }


    public static void TestRun() {

        System.out.println(FileInput.readFile("English.txt"));
        System.out.println(FileInput.readFile("Deutch.txt"));
        System.out.println(FileInput.readFile("Eesti.txt"));
        System.out.println(FileInput.readFile("Francais.txt"));
        System.out.println(FileInput.readFile("Italiano.txt"));
        System.out.println(FileInput.readFile("Norsk.txt"));
        System.out.println(FileInput.readFile("Suomi.txt"));
        System.out.println(FileInput.readFile("Svenska.txt"));
        new Language(FileInput.readFile("Suomi.txt").replaceAll("\\f", ""), "Finnish");
        new Language(FileInput.readFile("English.txt").replaceAll("\\e", ""), "English");
        new Language(FileInput.readFile("Suomi.txt").replaceAll("\\f", ""), "Deutch");
        new Language(FileInput.readFile("English.txt").replaceAll("\\e", ""), "Eesti");
        new Language(FileInput.readFile("Suomi.txt").replaceAll("\\f", ""), "Francais");
        new Language(FileInput.readFile("English.txt").replaceAll("\\e", ""), "Italiano");
        new Language(FileInput.readFile("Suomi.txt").replaceAll("\\f", ""), "Norsk");
        new Language(FileInput.readFile("English.txt").replaceAll("\\e", ""), "Suomi");
        new Language(FileInput.readFile("Suomi.txt").replaceAll("\\f", ""), "Svenska");
    }


}
