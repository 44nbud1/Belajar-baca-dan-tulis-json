package main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReadJson
{
    public static void main(String[] args) throws ParseException, IOException
    {
        /*
        Parsing data Json Object
         */
        // ambil data dari directory
        String fileLocation = "src/main/resources/latihan/jsonObject.json";
        Object object = new JSONParser().parse(new FileReader(fileLocation));
        // casting json object
        JSONObject jsonObject = (JSONObject) object;
        // mendapatkan nama
        String firstName = (String) jsonObject.get("firstName");
        String lastName = (String) jsonObject.get("lastName");
        String age = (String) jsonObject.get("age");

        System.out.println(firstName+" "+lastName+ " "+age);

        /*
        Parsing json object
         */
        fileLocation = "src/main/resources/latihan/objectInObject.json";
        Object obj = new JSONParser().parse(new FileReader(fileLocation));
        JSONObject jObject = (JSONObject) obj;
        Map address = (Map) jObject.get("address");
        String city = (String) address.get("city");
        System.out.println(city);
        for (Object a : address.entrySet())
        {
            System.out.println(a);
        }

        // Json Object
        fileLocation = "src/main/resources/latihan/array.json";
        Object ob = new JSONParser().parse(new FileReader(fileLocation));
        JSONObject objectJson = (JSONObject) ob;

        JSONArray js = (JSONArray) objectJson.get("phoneNumber");
        Map latihan = new HashMap();
        Iterator<Map.Entry> iterator = latihan.entrySet().iterator();

        Iterator itr = js.iterator();
        while (itr.hasNext())
        {
            iterator = ((Map)itr.next()).entrySet().iterator();
            while (iterator.hasNext())
            {
                Map.Entry pair = iterator.next();
                System.out.println("-------------------------------------------------");
                System.out.println(pair.getKey()+" "+pair.getValue());
            }
        }
    }
}
