package org.arep;

import static java.lang.Math.*;
import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String... args){
        staticFiles.location("/public");
        port(getPort());
        get("/Sin", (req,res) -> {
            String number= req.queryParams("number");
            return Math.sin(Double.parseDouble(number));
        });
        get("/Cos", (req,res) -> {
            String number= req.queryParams("number");
            return "" + Math.cos(Double.parseDouble(number));
        });
        get("/Palindromo", (req,res) -> {
            String word= req.queryParams("word").toLowerCase();
            String wordInvert= invertWord(word);
            if(word.equals(wordInvert)){
                return "La palabra " + word + " es palíndroma 😊😊😊";
            }else {
                return "La palabra " + word + " NO es palíndroma 😒😒😒 ";
            }
        });
        get("/Magnitud", (req,res) -> {
            Double number1= Double.valueOf((req.queryParams("number1")));
            Double number2= Double.valueOf(req.queryParams("number2"));
            Double result= Math.sqrt(pow(number1,2) + pow(number2,2));
            return "" + result.toString();
        });

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String invertWord(String word) {
        String invertWord ="";
        char caracter;
        for (int i=word.length()-1; i>=0; i--) {
            caracter = word.charAt(i);
            invertWord += caracter;
        }
        return invertWord;
    }


}