package com.company;

import java.io.*;
import java.util.HashMap;


//Kopiera från bankappen
public class FileInput {


    public static String readFile(String textFile){

       String text = new String();

    try {

        FileInputStream f = new FileInputStream(new File(textFile));
        int tempChar;
        while ((tempChar = f.read()) != -1) {

            text += String.valueOf((char) tempChar);
        }


    }
         catch (FileNotFoundException ex ){
            System.out.println("File was not found: " + ex.getMessage());
        } catch (IOException ex){
            System.out.println("IOException " + ex.getMessage());

        }
        return text;
    }
}

