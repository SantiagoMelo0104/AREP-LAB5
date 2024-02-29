package org.arep;

import static java.lang.Math.*;
import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String... args){
        staticFiles.location("/public");
        port(getPort());
        get("Sin", (req,res) -> {
            String number= req.queryParams("number");
            return Math.sin(Double.parseDouble(number));
        });
        get("/cos", (req,res) -> {
            String number= req.queryParams("number");
            System.out.println("-------------" + number);
            return "" + Math.cos(Double.parseDouble(number));
        });
//        get("Palindromo", (req,res) -> {
//            String palabra= req.queryParams("palabra");
//            return formulario(palabra);
//        });

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }


}