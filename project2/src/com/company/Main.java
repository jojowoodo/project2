package com.company;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner userIn = new Scanner(System.in);

        System.out.println("Var så vänlig å mata in en text för att jämföra det med ett språk.");

        String userlangIn = userIn.nextLine();

        Language userinL = new Language(userlangIn.replaceAll("[\\PL]","").toLowerCase(), null);

        //System.out.println("Ditt språk är högst antagligen: " + userinL.getContent());


       // LanguageStats.addLanguage(userinL);

        //TestRun();


    }

    public static void TestRun() {

       /* System.out.println(FileInput.readFile("English.txt"));
        System.out.println(FileInput.readFile("Deutch.txt"));
        System.out.println(FileInput.readFile("Eesti.txt"));
        System.out.println(FileInput.readFile("Francais.txt"));
        System.out.println(FileInput.readFile("Italiano.txt"));
        System.out.println(FileInput.readFile("Norsk.txt"));
        System.out.println(FileInput.readFile("Suomi.txt"));
        System.out.println(FileInput.readFile("Svenska.txt"));
      Language Suomi =  new Language(FileInput.readFile("Suomi.txt").replaceAll("[\\PL]", "").toLowerCase(), "Finnish");
      Language English  = new Language(FileInput.readFile("English.txt").replaceAll("[\\PL]", "").toLowerCase(), "English");
      Language Deutsch = new Language(FileInput.readFile("Deutch.txt").replaceAll("[\\PL]", "").toLowerCase(), "Deutsch");
      Language Eesti = new Language(FileInput.readFile("Eesti.txt").replaceAll("[\\PL]", "").toLowerCase(), "Eesti");
      Language Frenc =  new Language(FileInput.readFile("Francais.txt").replaceAll("[\\PL]", "").toLowerCase(), "French");
      Language Italian = new Language(FileInput.readFile("Italiano.txt").replaceAll("[\\PL]", "").toLowerCase(), "Italian");
      Language Norwegian =  new Language(FileInput.readFile("Norsk.txt").replaceAll("[\\PL]", "").toLowerCase(), "Norwegian");*/

        //new Language(FileInput.readFile("Svenska.txt").replaceAll("\\s", ""), "Svenska");

        System.out.println(FileInput.readFile("Suomi.txt"));

         //Suomi.calculateCharDistribution(Suomi.getContent());
          //Suomi.calculateCharDistribution(Suomi);

    }




}
