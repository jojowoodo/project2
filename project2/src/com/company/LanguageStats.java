package com.company;

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

        Scanner userIn = new Scanner(System.in);
        System.out.println("Var så vänlig å mata in en text för att jämföra det med ett språk.");

        //User input läses in
        String userlangIn = userIn.nextLine();

        //User input skapas som en language
        Language userinL = new Language(userlangIn.replaceAll("[\\PL]", "").toLowerCase(), null);
        userinL.calculateCharDistributionThreeLetters(userinL.getContent());
        userinL.calculateCharDistribution(userinL.getContent());


        double totalDiff = 0;
         double totalDiff2 = 0;
        LinkedHashMap<String, Double> resultHash = new LinkedHashMap<>();
        LinkedHashMap<String, Double> resultHash2 = new LinkedHashMap<>();

        for (int i = 0; i < guessArray.size(); i++) {

            HashMap<String, Double> userHash = userinL.calculateCharDistribution(userinL.getContent());
            HashMap<String, Double> LoopHash = guessArray.get(i).calculateCharDistribution(guessArray.get(i).getContent());


            for (String j : LoopHash.keySet()) {
                if (userHash.get(j) == null) {
                    totalDiff += Math.pow(LoopHash.get(j) - 0, 2);

                } else {
                    totalDiff += Math.pow(LoopHash.get(j) - userHash.get(j), 2);
                }
            }
            resultHash.put(guessArray.get(i).getLanguageLabel(), totalDiff);
            totalDiff = 0;

        }
        for (HashMap.Entry entry : resultHash.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        System.out.println("\n");



        ArrayList<Language> guessArray2 = addLanguage();


        for (int i = 0; i < guessArray2.size(); i++) {

            HashMap<String, Double> userHash2 = userinL.calculateCharDistributionThreeLetters(userinL.getContent());
            HashMap<String, Double> LoopHash2 = guessArray2.get(i).calculateCharDistributionThreeLetters(guessArray.get(i).getContent());


            for (String j : LoopHash2.keySet()) {
                if (userHash2.get(j) == null) {
                    totalDiff2 += Math.pow(LoopHash2.get(j) - 0, 2);

                } else {
                    totalDiff2 += Math.pow(LoopHash2.get(j) - userHash2.get(j), 2);
                }
            }
            resultHash2.put(guessArray2.get(i).getLanguageLabel(), totalDiff2);
            totalDiff2 = 0;


        }

        for (HashMap.Entry entry : resultHash2.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }






    }





   /* public static void threeletterCombo() {

        LinkedHashMap<String, Integer> theeLetters = new LinkedHashMap();
        String k = "Kalle skäller";
        System.out.println(theeLetters);
        ArrayList<Language> guessArray2 = addLanguage();


       /* for(int j = 1; j++<k.length() - 1;j++) {
            String s = "kal";
            int i = theeLetters.get(s) + 1;
            theeLetters.put(s,i);
        } */


   // }


        /*
        for (String i : theeLetters.keySet()) {
            System.out.println("key: " + i + " value: " + theeLetters.get(i));
        }


/*
    }

    public class All_Possible_Combinations_5 {

        public void main(String args[]) {

            for (int i = 97; i <= 122; i++) {
                for (int j = 97; j <= 122; j++) {
                    for (int k = 97; k <= 122; k++) {
                        for (int l = 97; l <= 122; l++) {
                            for (int m = 97; m <= 122; m++) {
                                System.out.print((char) i);
                                System.out.print((char) j);
                                System.out.print((char) k);
                                System.out.print((char) l);
                                System.out.println((char) m);
                            }
                        }
                    }
                }
            }

        }
   */
   /* } */
