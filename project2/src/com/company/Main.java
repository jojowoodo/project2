package com.company;
import java.util.Scanner;



public class Main {




    public static void main(String[] args) {


        String s = "Hello ivan my penis is big";
        char a[] = s.toCharArray();

        for(int i=0; i < a.length; i++) {
            if(a[i] != ' ' && (i == 0 || a[i-1] == ' ')) {
                System.out.println(a[i]);
            }
        }

       LanguageStats.guessLanguage();
      //  LanguageStats.threeletterCombo();




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
