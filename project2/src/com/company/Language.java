package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Language {
    String content;
    String languageLabel;
    HashMap<String, Double> charDistribution = new HashMap<>();
    HashMap<Character, Integer> charCountMap = new HashMap<>();


    public Language(String c, String l) {

        content = c;
        languageLabel = l;

    }

    public String getContent() {
        return content;
    }
    public String getLanguageLabel(){
        return languageLabel;
    }

    public  HashMap<String, Double> calculateCharDistribution(String inputString) {
        //totala mängden bokstäver
        Integer total = 0;


        //Sätter Varje bokstav av inputString i en Array
        char[] strArray = inputString.toCharArray();

        //går igenom varje bokstav av strArray
        for (char bokstav : strArray) {
            //om vår hashmap redan innehåller bokstaven, incrementeras den bokstaven med 1
            if (charCountMap.containsKey(bokstav)) {
                charCountMap.put(bokstav, charCountMap.get(bokstav) + 1);

            } else {
                //ifall bokstaven inte finns ännu, blir sätter vi bokstavsmängden till 1
                charCountMap.put(bokstav, 1);
            }
        }

        //räknar totala mängden av bokstäver i stringen, går igenom hashmappen och lägger till varje mängd av bokstäver
        for (HashMap.Entry entry : charCountMap.entrySet()) {
            total += (Integer) entry.getValue();
        }
        //Lägger till i slutliga hashmappen själva bokstaven som key(string) och procentmängden av bokstaven som value
        for (HashMap.Entry entry : charCountMap.entrySet()) {
            Integer temp = (Integer) entry.getValue();
            charDistribution.put(entry.getKey().toString(), (double) temp / (double) total);
        }

        //returnerar en hashmap av teckenfördelningen i procent.
        return charDistribution;

    }

    public  HashMap<String, Double> calculateCharDistributionThreeLetters(String inputString) {
        HashMap <String,Double> threeCountMap = new HashMap<>();
        ArrayList<String> threeLetters = new ArrayList<>();
        String text = inputString;
        int j = 0;
        for (int i = 1; i < text.length() -1; i++) {

            char a = text.charAt(0 + j);
            char b = text.charAt(1 + j);
            char c = text.charAt(2 + j);
            String result = ""+a + b + c;
            threeLetters.add(result);
            j++;



        }
        for (int i = 0; i < threeLetters.size();i++){

            if(den inte finns){
                threeCountMap.put(threeLetters.get(i), 1.0);
            }
            else{
                threeCountMap.put(threeLetters.get(i), threeCountMap.get(threeLetters.get(i)) + 1.0);
            }
        }


        //totala mängden bokstäver
        Integer total = 0;


        //Sätter Varje bokstav av inputString i en Array
        char[] strArray = inputString.toCharArray();

        //går igenom varje bokstav av strArray
        for (char bokstav : strArray) {
            //om vår hashmap redan innehåller bokstaven, incrementeras den bokstaven med 1
            if (charCountMap.containsKey(bokstav)) {
                charCountMap.put(bokstav, charCountMap.get(bokstav) + 1);

            } else {
                //ifall bokstaven inte finns ännu, blir sätter vi bokstavsmängden till 1
                charCountMap.put(bokstav, 1);
            }
        }

        //räknar totala mängden av bokstäver i stringen, går igenom hashmappen och lägger till varje mängd av bokstäver
        for (HashMap.Entry entry : charCountMap.entrySet()) {
            total += (Integer) entry.getValue();
        }
        //Lägger till i slutliga hashmappen själva bokstaven som key(string) och procentmängden av bokstaven som value
        for (HashMap.Entry entry : charCountMap.entrySet()) {
            Integer temp = (Integer) entry.getValue();
            charDistribution.put(entry.getKey().toString(), (double) temp / (double) total);
        }

        //returnerar en hashmap av teckenfördelningen i procent.
        return charDistribution;

    }


}







