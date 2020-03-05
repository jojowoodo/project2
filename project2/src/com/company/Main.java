package com.company;

public class Main {

    public static void main(String[] args) {

        TestRun();
    }


    public static void TestRun(){

        System.out.println(FileInput.readFile("English.txt"));
        new Language(FileInput.readFile("English.txt").replaceAll("\\e",""),"English");
    }



}
