package controller.Business.helper.json;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConvertJson {

    JSONObject obj;
    JSONParser parser = new JSONParser();

    public JSONObject getJson(String path) {
        try {
            obj = (JSONObject) parser.parse(new FileReader(path));
        } catch (Exception e) {
            
            System.out.println("error");
        }
        return obj;
    }

    public JSONObject getObj(String obj2) {
        try {
          obj = (JSONObject) parser.parse(obj2);
        } catch (ParseException e) {
            
            e.printStackTrace();
            System.out.println("erro na impressõa");
        }
        return obj;
    }

    
    

}
