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

    }


    //Language finnish = new Language();



}