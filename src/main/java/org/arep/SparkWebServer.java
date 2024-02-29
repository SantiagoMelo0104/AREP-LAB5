package org.arep;

import static java.lang.Math.*;
import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String... args){
        staticFiles.location("./lo");
        port(getPort());
        get("Sin", (req,res) -> {
            String number= req.queryParams("number");
            return Math.sin(Double.parseDouble(number));
        });
        get("Cos", (req,res) -> {
            String number= req.queryParams("number");
            return Math.cos(Double.parseDouble(number));
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

    public static String formulario(Double number){
        String output= "<!DOCTYPE html>\n" +
                "<html>    \n" +
                "<head>        \n" +
                "<title>Form Example</title>        \n" +
                "<meta charset=\"UTF-8\">        \n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">    \n" +
                "</head>    \n" +
                "<body>        \n" +
                "<h1>Form with GET</h1>        \n" +
                "<form action=\"/hello\">           \n" +
                "<label for=\"name\">Datos:</label><br>            \n" +
                "<input type=\"text\" id=\"datos\" name=\"name\" value=\"\"><br><br>            \n" +
                "<input type=\"button\" value=\"Enviar\" onclick=\"loadGetMsg()\">        \n" +
                "</form>         <div id=\"getrespmsg\"></div>        \n" +
                "<script>            function loadGetMsg() {                \n" +
                "let nameVar = document.getElementById(\"datos\").value;                \n" +
                "const xhttp = new XMLHttpRequest();                \n" +
                "xhttp.onload = function() {                    \n" +
                "document.getElementById(\"getrespmsg\").innerHTML =                    this.responseText;                }                \n" +
                "xhttp.open(\"GET\", \"/Cos?number=\"+nameVar);                xhttp.send();            }        </script>       \n" +
                "</body>\n" +
                "</html>";
        return output;
    }
}