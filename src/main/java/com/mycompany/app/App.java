package com.mycompany.app;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    public static String search(ArrayList<String> array, int sma , int big) {//bu foksiyon arrayda ki uzunlugu sma ile big arasında olan ilk
      System.out.println("inside search");				     //stringi doner
      if(big<sma)//kucuk olması gereken degiskenin buyuk olma ihtimali
	return "";
      if (array == null) return "";

      for (String elt : array) {
        if (elt.length()<=big&&elt.length()>=sma) return elt;
      }
      return "";
    }

   public static void main(String[] args) {

	port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello,World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            String value = sc1.next().replaceAll("\\s","");
            inputList.add(value);
          }
          System.out.println(inputList);


          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);
	  
	  String input3 = req.queryParams("input3").replaceAll("\\s","");
          int input3AsInt = Integer.parseInt(input3);

          String result = App.search(inputList, input2AsInt,input3AsInt);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());
              get("/compute", (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

