package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class LanguageStats {

    public static ArrayList<Language> Languages = new ArrayList();

    public static ArrayList<Language> addLanguage() {


        Language Svenska = new Language(FileInput.readFile("Svenska.txt").replaceAll("[\\PL]", "").toLowerCase(), "Swedish");
        Language English = new Language(FileInput.readFile("English.txt").replaceAll("[\\PL]", "").toLowerCase(), "English");
        Language Suomi = new Language(FileInput.readFile("Suomi.txt").replaceAll("[\\PL]", "").toLowerCase(), "Finnish");
        Language Deutsch = new Language(FileInput.readFile("Deutch.txt").replaceAll("[\\PL]", "").toLowerCase(), "Deutsch");
        Language Eesti = new Language(FileInput.readFile("Eesti.txt").replaceAll("[\\PL]", "").toLowerCase(), "Eesti");
        Language Frenc = new Language(FileInput.readFile("Francais.txt").replaceAll("[\\PL]", "").toLowerCase(), "French");
        Language Italian = new Language(FileInput.readFile("Italiano.txt").replaceAll("[\\PL]", "").toLowerCase(), "Italian");
        Language Norwegian = new Language(FileInput.readFile("Norsk.txt").replaceAll("[\\PL]", "").toLowerCase(), "Norwegian");
        Languages.add(Svenska);
        Languages.add(English);
        Languages.add(Suomi);
        Languages.add(Deutsch);
        Languages.add(Eesti);
        Languages.add(Frenc);
        Languages.add(Italian);
        Languages.add(Norwegian);


        return Languages;
    }

    public static void guessLanguage() {

        ArrayList<Language> guessArray = addLanguage();
        ArrayList<Language> guessArray2 = addLanguage();
        ArrayList<Language> guessArray3 = addLanguage();
        LinkedHashMap<String, Double> resultHash = new LinkedHashMap<>();
        LinkedHashMap<String, Double> resultHash2 = new LinkedHashMap<>();
        LinkedHashMap<String, Double> resultHash3 = new LinkedHashMap<>();
        double totalDiff = 0.0;
        double totalDiff2 = 0.0;
        double totalDiff3= 0.0;

       HashMap resultLanguage = new HashMap();

        Scanner userIn = new Scanner(System.in);
        System.out.println("Var så vänlig å mata in en text för att jämföra det med ett språk.");

        //User input läses in
        String userlangIn = userIn.nextLine();

        //User input skapas som en language
        Language userinL = new Language(userlangIn.replaceAll("[\\PL]", "").toLowerCase(), null);

        for (int i = 0; i < guessArray.size(); i++) {
            HashMap<String, Double> userOneHash = userinL.calculateCharDistribution(userinL.getContent());
            HashMap<String, Double> oneCharHash = guessArray.get(i).calculateCharDistribution(guessArray.get(i).getContent());

            for (String j : oneCharHash.keySet()) {
                if (userOneHash.get(j) == null) {
                    totalDiff += Math.pow(oneCharHash.get(j) - 0, 2);

                } else {
                    totalDiff += Math.pow(oneCharHash.get(j) - userOneHash.get(j), 2);

                }


            }
            resultHash.put(guessArray.get(i).getLanguageLabel(), totalDiff);
            totalDiff = 0;



        }

        for (HashMap.Entry entry : resultHash.entrySet()) {
            System.out.println("All letter algo: \n"  + entry.getKey() + " " + entry.getValue() + " \n");
            resultLanguage.put(entry.getKey() , entry.getValue());
            System.out.println(" dethär är ett test" + resultLanguage);
        }


        for (int i = 0; i < guessArray2.size(); i++) {

            HashMap<String, Double> userThreeHash = userinL.calculateCharDistributionThreeLetters(userinL.getContent());
            HashMap<String, Double> threeCharHash = guessArray.get(i).calculateCharDistributionThreeLetters(guessArray.get(i).getContent());


            for (String j : threeCharHash.keySet()) {
                if (userThreeHash.get(j) == null) {
                    totalDiff2 += Math.pow(threeCharHash.get(j) - 0, 2);

                } else {
                    totalDiff2 += Math.pow(threeCharHash.get(j) - userThreeHash.get(j), 2);
                }
            }
            resultHash2.put(guessArray2.get(i).getLanguageLabel(), totalDiff2);
            totalDiff2 = 0;


        }

        for (HashMap.Entry entry : resultHash2.entrySet()) {
            System.out.println("Three Letter algo: \n" + entry.getKey() + " " + entry.getValue() + " \n");
        }

        //FirstLetterOfEachWord
        for (int i = 0; i < guessArray3.size(); i++) {
            HashMap<String, Double> userFirstHash = userinL.calculateCharDistributionFirstLetter(userinL.getContent());
            HashMap<String, Double> firstCharHash = guessArray.get(i).calculateCharDistributionFirstLetter(guessArray.get(i).getContent());

            for (String j : firstCharHash.keySet()) {
                if (userFirstHash.get(j) == null) {
                    totalDiff3 += Math.pow(firstCharHash.get(j) - 0, 2);

                } else {
                    totalDiff3 += Math.pow(firstCharHash.get(j) - userFirstHash.get(j), 2);

                }


            }
            resultHash3.put(guessArray3.get(i).getLanguageLabel(), totalDiff3);
            totalDiff3 = 0;


        }
        for (HashMap.Entry entry : resultHash3.entrySet()) {
            System.out.println("First Letter algo: \n" + entry.getKey() + " " + entry.getValue() + " \n");
        }




    }

}



