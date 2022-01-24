package utilities.data;

import java.util.LinkedHashMap;
import java.util.Map;

public class Data {

    public static Map<String, String> DataElements(){
        Map<String, String> dataElements = new LinkedHashMap<String, String>();
        dataElements.put("Apple","15");
        dataElements.put("Apricots","20");
        dataElements.put("Bananas","25");
        dataElements.put("Blueberries","30");
        dataElements.put("Cantaloupe","1");
        dataElements.put("Cherries","12");
        return dataElements;
    }
}
