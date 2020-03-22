package com.company;

import java.text.DecimalFormat;
import java.util.*;


public class LanguageStats {

    public static ArrayList<Language> Languages = new ArrayList();
    public static ArrayList<Language> LanguagesWithSpaces = new ArrayList();

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


        return Languages;
    }

    public static ArrayList<Language> addLanguageWithSpaces() {


        Language Svenska2 = new Language(FileInput.readFile("Svenska.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()«-]", "").replaceAll("\\]", "").replaceAll("\\s+", " ").toLowerCase(), "Swedish");
        Language English2 = new Language(FileInput.readFile("English.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()«-]", "").replaceAll("\\]", "").replaceAll("\\s+", " ").toLowerCase(), "English");
        Language Suomi2 = new Language(FileInput.readFile("Suomi.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()«-]", "").replaceAll("\\]", "").replaceAll("\\s+", " ").toLowerCase(), "Finnish");
        Language Deutsch2 = new Language(FileInput.readFile("Deutch.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()«-]", "").replaceAll("\\]", "").replaceAll("\\s+", " ").toLowerCase(), "Deutsch");
        Language Eesti2 = new Language(FileInput.readFile("Eesti.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()«-]", "").replaceAll("\\]", "").replaceAll("\\s+", " ").toLowerCase(), "Eesti");
        Language Frenc2 = new Language(FileInput.readFile("Francais.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()«-]", "").replaceAll("\\]", "").replaceAll("\\s+", " ").toLowerCase(), "French");
        Language Italian2 = new Language(FileInput.readFile("Italiano.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()«-]", "").replaceAll("\\]", "").replaceAll("\\s+", " ").toLowerCase(), "Italian");
        Language Norwegian2 = new Language(FileInput.readFile("Norsk.txt").replaceAll("[;\\[0-9:*?\"<>|&',.()«-]", "").replaceAll("\\]", "").replaceAll("\\s+", " ").toLowerCase(), "Norwegian");

        LanguagesWithSpaces.add(Svenska2);
        LanguagesWithSpaces.add(English2);
        LanguagesWithSpaces.add(Suomi2);
        LanguagesWithSpaces.add(Deutsch2);
        LanguagesWithSpaces.add(Eesti2);
        LanguagesWithSpaces.add(Frenc2);
        LanguagesWithSpaces.add(Italian2);
        LanguagesWithSpaces.add(Norwegian2);


        return LanguagesWithSpaces;
    }

    public static HashMap<String, Double> sortByValue(HashMap<String, Double> hm) {

        List<Map.Entry<String, Double>> list =
                new LinkedList<Map.Entry<String, Double>>(hm.entrySet());


        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });


        HashMap<String, Double> temp = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void guessLanguage() {

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(3);
        ArrayList<Language> guessArray = addLanguage();
        ArrayList<Language> guessArray2 = addLanguage();
        ArrayList<Language> guessArray3 = addLanguageWithSpaces();
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
        Language userinL = new Language(userlangIn.replaceAll("[\\PL]", "").toLowerCase(), "unknown");
        Language UserinLWithSpaces = new Language(userlangIn.replaceAll("[;\\[0-9:*?\"<>|&',.()«-]", "").replaceAll("\\]", "").replaceAll("\\s+", " ").toLowerCase(), "unknown");


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


        //FirstLetterOfEachWord
        for (int i = 0; i < guessArray3.size(); i++) {
            HashMap<String, Double> userFirstHash = UserinLWithSpaces.calculateCharDistributionFirstLetter(UserinLWithSpaces.getContent());
            HashMap<String, Double> firstCharHash = guessArray3.get(i).calculateCharDistributionFirstLetter(guessArray3.get(i).getContent());


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


        HashMap<String, Double> finalHash = new HashMap<>();
        for (HashMap.Entry entry : resultHash.entrySet()) {
            double total = ((double) entry.getValue() + resultHash2.get(entry.getKey()) + resultHash3.get(entry.getKey())) / 3;
            finalHash.put(entry.getKey().toString(), total);
        }

        HashMap<String, Double> moreFinalHash = sortByValue(finalHash);
        int i = 1;
        System.out.println("-------------------------------------------------------------------------------------------");
        for (HashMap.Entry entry : moreFinalHash.entrySet()) {
            System.out.println(entry.getKey() + " Analys 1: " + df.format(resultHash.get(entry.getKey())) + " Analys 2: " + df.format(resultHash2.get(entry.getKey())) + " Analys 3: " + df.format(resultHash3.get(entry.getKey())) + " Kombinerat: " + df.format(entry.getValue()) + " Rangordning " + i);
            i++;
        }
        System.out.println("-------------------------------------------------------------------------------------------");


    }
}



