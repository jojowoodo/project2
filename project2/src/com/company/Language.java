package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Language {
    String content;
    String languageLabel;
    //skapar arrays
    HashMap<String, Double> CountMap = new HashMap<>();
    HashMap<String, Double> CountResult = new HashMap<>();
    HashMap<String, Double> oneLetterResult = new HashMap<>();
    HashMap<String, Double> threeLetterResult = new HashMap<>();
    HashMap<String, Double> firstLetterResult = new HashMap<>();


    public Language(String c, String l) {

        content = c;
        languageLabel = l;
    }

    public String getContent() {
        return content;
    }

    public String getLanguageLabel() {
        return languageLabel;
    }

    //sätter in alla bokstäver som finns i en arraylist
    public HashMap<String, Double> calculateCharDistribution(String inputString) {
        ArrayList<String> oneLetters = new ArrayList<>();


        String text = inputString;
        int j = 0;
        for (int i = 1; i < text.length() - 1; i++) {
            char a = text.charAt(0 + j);
            String result = "" + a;
            oneLetters.add(result);
            j++;
        }
        oneLetterResult = getCharDistritubtion(oneLetters);
        return oneLetterResult;
    }

    //sätter in alla tre bokstävers kombionationer som finns i en arraylist
    public HashMap<String, Double> calculateCharDistributionThreeLetters(String inputString) {
        ArrayList<String> threeLetters = new ArrayList<>();
        String text = inputString;
        int j = 0;
        for (int i = 1; i < text.length() - 1; i++) {

            char a = text.charAt(0 + j);
            char b = text.charAt(1 + j);
            char c = text.charAt(2 + j);
            String result = "" + a + b + c;

            threeLetters.add(result);
            j++;
        }
        threeLetterResult = getCharDistritubtion(threeLetters);

        return threeLetterResult;
    }

    //sätter in alla första bokstäver från ord som finns i en arraylist
    public HashMap<String, Double> calculateCharDistributionFirstLetter(String inputString) {
        ArrayList<String> firstLetter = new ArrayList<>();
        String text = inputString;


        String[] g = text.split(" ");
        for (int i = 0; i < g.length; i++) {
            String s = g[i];
            firstLetter.add(String.valueOf(s.charAt(0)));
        }


        firstLetterResult = getCharDistritubtion(firstLetter);

        return firstLetterResult;
    }

    // metod för att sätta in bokstäver som key i en hashmap och iterate +1 om den redan finns i hashmappen annars blir det 1
    public HashMap<String, Double> getCharDistritubtion(ArrayList<String> charArray) {
        Double total = 0.0;
        for (int i = 0; i < charArray.size(); i++) {

            if (!CountMap.containsKey(charArray.get(i))) {
                CountMap.put(charArray.get(i), 1.0);
            } else {
                CountMap.put(charArray.get(i), CountMap.get(charArray.get(i)) + 1.0);
            }
        }

        for (HashMap.Entry entry : CountMap.entrySet()) {
            total += (Double) entry.getValue();
        }

        for (HashMap.Entry entry : CountMap.entrySet()) {
            Double temp = (Double) entry.getValue();
            CountResult.put(entry.getKey().toString(), temp / total);
        }

        return CountResult;
    }

}







