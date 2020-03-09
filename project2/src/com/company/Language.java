package com.company;


import java.util.HashMap;
import java.util.Map;

public class Language {
    String content;
    String languageLabel;
    HashMap <String, Double> charDistribution = new HashMap<>();
    HashMap<Character, Integer> charCountMap = new HashMap<>();


   public Language(String c, String l) {

       content = c;
       languageLabel = l;

    }

    public String getContent(){
       return content;
    }

    public void calculateCharDistribution(String inputString) {
        Integer total = 0;

        // Creating a HashMap containing char
        // as a key and occurrences as  a value



        // Converting given string to char array

        char[] strArray = inputString.toCharArray();

        // checking each char of strArray
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {

                // If char is present in charCountMap,
                // incrementing it's count by 1
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else {

                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                charCountMap.put(c, 1);
            }
        }

        // Printing the charCountMap

        for (HashMap.Entry entry : charCountMap.entrySet()) {
            total += (Integer) entry.getValue();
        }

        for (HashMap.Entry entry : charCountMap.entrySet()) {
          Integer temp = (Integer) entry.getValue();
            charDistribution.put(entry.getKey().toString(),(double)temp/(double)total);
        }

        for (HashMap.Entry entry : charDistribution.entrySet()) {
            System.out.println(entry.getKey()+ " " +entry.getValue());
        }


    }



}







