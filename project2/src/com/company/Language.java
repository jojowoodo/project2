package com.company;
import java.util.HashMap;

public class Language {
    String content;
    String languageLabel;
    HashMap <String, Double> charDistribution = new HashMap<>();


   public Language(String c, String l) {

       content = c;
       languageLabel = l;

    }

    public void calculateCharDistribution() {

        new Language(FileInput.readFile("Suomi.txt").replaceAll("\\f",""),"Finnish");
        new Language(FileInput.readFile("English.txt").replaceAll("\\e",""),"English");

    }


    //Language finnish = new Language();



}
