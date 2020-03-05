package com.company;

import java.io.*;
import java.util.HashMap;


//Kopiera från bankappen
public class FileInput {


    public static String readFile(String URL)

       String text = new String();
        try {

            FileInputStream f = new FileInputStream(new File(URL));
            int tempChar;
            while((tempChar = f.read()) != -1) {

                text += String.valueOf((char)tempChar);
            }



        } catch (FileNotFoundException e) {
            System.out.println("Kunde inte öppna filen 'AccountDb");
        } catch (IOException e) {
            System.out.println("IOException!!! " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException bad luck");
        }


        return text;
    }
}
