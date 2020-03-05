package com.company;

public class Main {

    public static void main(String[] args) {

        TestRun();
    }


    public static void TestRun() {

       /* System.out.println(FileInput.readFile("English.txt"));
        System.out.println(FileInput.readFile("Deutch.txt"));
        System.out.println(FileInput.readFile("Eesti.txt"));
        System.out.println(FileInput.readFile("Francais.txt"));
        System.out.println(FileInput.readFile("Italiano.txt"));
        System.out.println(FileInput.readFile("Norsk.txt"));
        System.out.println(FileInput.readFile("Suomi.txt"));
        System.out.println(FileInput.readFile("Svenska.txt")); */
      Language Finnish =  new Language(FileInput.readFile("Suomi.txt").replaceAll("\\s", ""), "Finnish");
        new Language(FileInput.readFile("English.txt").replaceAll("\\s", ""), "English");
        new Language(FileInput.readFile("Deutch.txt").replaceAll("\\s", ""), "Deutch");
        new Language(FileInput.readFile("Eesti.txt").replaceAll("\\s", ""), "Eesti");
        new Language(FileInput.readFile("Francais.txt").replaceAll("\\s", ""), "Francais");
        new Language(FileInput.readFile("Italiano.txt").replaceAll("\\s", ""), "Italiano");
        new Language(FileInput.readFile("Norsk.txt").replaceAll("\\s", ""), "Norsk");
        new Language(FileInput.readFile("Suomi.txt").replaceAll("\\s", ""), "Suomi");
        new Language(FileInput.readFile("Svenska.txt").replaceAll("\\s", ""), "Svenska");

        System.out.println(Finnish.getContent());

    }


}
