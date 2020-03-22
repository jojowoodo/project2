package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.text.DecimalFormat;
import java.util.*;

public class LanguageStats {

    public static ArrayList<Language> Languages = new ArrayList();
    public static ArrayList<Language> Languages2 = new ArrayList();

    public static ArrayList<Language> addLanguage() {


        Language Svenska = new Language(FileInput.readFile("Svenska.txt").replaceAll("\\PL", "").toLowerCase(), "Swedish");
        Language English = new Language(FileInput.readFile("English.txt").replaceAll("\\PL", "").toLowerCase(), "English");
        Language Suomi = new Language(FileInput.readFile("Suomi.txt").replaceAll("\\PL", "").toLowerCase(), "Finnish");
        Language Deutsch = new Language(FileInput.readFile("Deutch.txt").replaceAll("\\PL", "").toLowerCase(), "Deutsch");
        Language Eesti = new Language(FileInput.readFile("Eesti.txt").replaceAll("\\PL", "").toLowerCase(), "Eesti");
        Language Frenc = new Language(FileInput.readFile("Francais.txt").replaceAll("\\PL", "").toLowerCase(), "French");
        Language Italian = new Language(FileInput.readFile("Italiano.txt").replaceAll("\\PL", "").toLowerCase(), "Italian");
        Language Norwegian = new Language(FileInput.readFile("Norsk.txt").replaceAll("\\PL", "").toLowerCase(), "Norwegian");


        Languages.add(Svenska);
        Languages.add(English);
        Languages.add(Suomi);
        Languages.add(Deutsch);
        Languages.add(Eesti);
        Languages.add(Frenc);
        Languages.add(Italian);
        Languages.add(Norwegian);


        return Languages2;
    }

    public static ArrayList<Language> addLanguage2() {


        Language Svenska2 = new Language(FileInput.readFile("Svenska.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()-]", "").replaceAll("\\]","").toLowerCase(), "Swedish");
        Language English2 = new Language(FileInput.readFile("English.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()-]", "").replaceAll("\\]","").toLowerCase(), "English");
        Language Suomi2 = new Language(FileInput.readFile("Suomi.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()-]", "").replaceAll("\\]","").toLowerCase(), "Finnish");
        Language Deutsch2 = new Language(FileInput.readFile("Deutch.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()-]", "").replaceAll("\\]","").toLowerCase(), "Deutsch");
        Language Eesti2 = new Language(FileInput.readFile("Eesti.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()-]", "").replaceAll("\\]","").toLowerCase(), "Eesti");
        Language Frenc2 = new Language(FileInput.readFile("Francais.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()-]", "").replaceAll("\\]","").toLowerCase(), "French");
        Language Italian2 = new Language(FileInput.readFile("Italiano.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()-]", "").replaceAll("\\]","").toLowerCase(), "Italian");
        Language Norwegian2 = new Language(FileInput.readFile("Norsk.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()-]", "").replaceAll("\\]","").toLowerCase(), "Norwegian");
        Languages2.add(Svenska2);
        Languages2.add(English2);
        Languages2.add(Suomi2);
        Languages2.add(Deutsch2);
        Languages2.add(Eesti2);
        Languages2.add(Frenc2);
        Languages2.add(Italian2);
        Languages2.add(Norwegian2);


        return Languages2;
    }

    public static void guessLanguage() {

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        ArrayList<Language> guessArray = addLanguage();
        ArrayList<Language> guessArray2 = addLanguage();
        ArrayList<Language> guessArray3 = addLanguage2();
        LinkedHashMap<String, Double> resultHash = new LinkedHashMap<>();
        LinkedHashMap<String, Double> resultHash2 = new LinkedHashMap<>();
        LinkedHashMap<String, Double> resultHash3 = new LinkedHashMap<>();
        double totalDiff = 0.0;
        double totalDiff2 = 0.0;
        double totalDiff3 = 0.0;

        //resultat hashmap
        LinkedHashMap resultLanguage = new LinkedHashMap();

        //User input
        Scanner userIn = new Scanner(System.in);
        System.out.println("Var så vänlig å mata in en text för att jämföra det med ett språk.");

        //User input läses in
        String userlangIn = userIn.nextLine();


        //User input skapas som en language
        Language userinL = new Language(userlangIn.replaceAll("[;\\\\/:*?\\\"<>|&']", "").toLowerCase(), "unknown");
        Language UserinLWithSpaces = new Language(userlangIn.replaceAll("[;\\[0-9:*?\"<>|&',.()-]", "").replaceAll("\\]","").toLowerCase(), "unknown");


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
            //System.out.println("All letter algo: \n"  + entry.getKey() + " " + entry.getValue() + " \n");
            resultLanguage.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Analys 1: " + resultLanguage);
        resultLanguage.clear();

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
            //System.out.println("Three Letter algo: \n" + entry.getKey() + " " + entry.getValue() + " \n");
            resultLanguage.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Analys 2: " + resultLanguage);
        resultLanguage.clear();


        //FirstLetterOfEachWord
        for (int i = 0; i < guessArray3.size(); i++) {
            HashMap<String, Double> userFirstHash = UserinLWithSpaces.calculateCharDistributionFirstLetter(UserinLWithSpaces.getContent());
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
            //System.out.println("First Letter algo: \n" + entry.getKey() + " " + entry.getValue() + " \n");
            resultLanguage.put(entry.getKey(), entry.getValue());
        }

        System.out.println(df.format("Analys 3: "  + resultLanguage));
        resultLanguage.clear();




    }

}



