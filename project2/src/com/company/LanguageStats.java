package com.company;

import java.util.HashMap;

 public class LanguageStats {
   HashMap <String, Language> languages = new HashMap<>();

   public static void addLanguage( Language addLang ) {


       Language Svenska =  new Language(FileInput.readFile("Svenska.txt").replaceAll("[\\PL]", "").toLowerCase(), "Swedish");
       Language English  = new Language(FileInput.readFile("English.txt").replaceAll("[\\PL]", "").toLowerCase(), "English");

       addLang.calculateCharDistribution(addLang.getContent());
       //English.calculateCharDistribution(English.getContent());
       //Svenska.calculateCharDistribution(Svenska.getContent());

   }
    public void guessLanguage(Language guessLang){



    }
}
