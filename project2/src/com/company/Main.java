package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        TestRun();
    }


    public static void TestRun() {

        Scanner input = new Scanner(System.in);
        new Language(FileInput.readFile("Suomi.txt").replaceAll("\\s", ""), "Finnish");
        new Language(FileInput.readFile("English.txt").replaceAll("\\s", ""), "English");
        new Language(FileInput.readFile("Deutch.txt").replaceAll("\\s", ""), "Deutch");
        new Language(FileInput.readFile("Eesti.txt").replaceAll("\\s", ""), "Eesti");
        new Language(FileInput.readFile("Francais.txt").replaceAll("\\s", ""), "Francais");
        new Language(FileInput.readFile("Italiano.txt").replaceAll("\\s", ""), "Italiano");
        new Language(FileInput.readFile("Norsk.txt").replaceAll("\\s", ""), "Norsk");
        new Language(FileInput.readFile("Suomi.txt").replaceAll("\\s", ""), "Suomi");
        new Language(FileInput.readFile("Svenska.txt").replaceAll("\\s", ""), "Svenska");


        String inputText ="Hej Dator, Kan dugissa vilket språk lagskriver på nu?";
        new Language(inputText.replaceAll("\\s",""),"unknown");
    }


}
