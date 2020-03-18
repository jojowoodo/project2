package com.company;

import java.util.ArrayList;
import java.util.HashMap;

 public class LanguageStats {
   HashMap <String, Language> languages = new HashMap<>();

   public static void addLanguage( Language addLang ) {

       ArrayList Languages = new ArrayList();
       Language Svenska =  new Language(FileInput.readFile("Svenska.txt").replaceAll("[\\PL]", "").toLowerCase(), "Swedish");
       Language English  = new Language(FileInput.readFile("English.txt").replaceAll("[\\PL]", "").toLowerCase(), "English");
       Language Suomi =  new Language(FileInput.readFile("Suomi.txt").replaceAll("[\\PL]", "").toLowerCase(), "Finnish");
       Language Deutsch = new Language(FileInput.readFile("Deutch.txt").replaceAll("[\\PL]", "").toLowerCase(), "Deutsch");
       Language Eesti = new Language(FileInput.readFile("Eesti.txt").replaceAll("[\\PL]", "").toLowerCase(), "Eesti");
       Language Frenc =  new Language(FileInput.readFile("Francais.txt").replaceAll("[\\PL]", "").toLowerCase(), "French");
       Language Italian = new Language(FileInput.readFile("Italiano.txt").replaceAll("[\\PL]", "").toLowerCase(), "Italian");
       Language Norwegian =  new Language(FileInput.readFile("Norsk.txt").replaceAll("[\\PL]", "").toLowerCase(), "Norwegian");
       Languages.add(Svenska);
       Languages.add(English);
       Languages.add(Suomi);
       Languages.add(Deutsch);
       Languages.add(Eesti);
       Languages.add(Frenc);
       Languages.add(Italian);
       Languages.add(Norwegian);

       System.out.println(Languages);

       //addLang.calculateCharDistribution(addLang.getContent());
       //English.calculateCharDistribution(English.getContent());
       //Svenska.calculateCharDistribution(Svenska.getContent());

   }
     public static void guessLanguage(){
         ArrayList guessArray = addLanguage();

         for (int i = 0; i < guessArray.size(); i++ ){
             //   guessArray.get(i).calculateCharDistribution();

         }

     }
