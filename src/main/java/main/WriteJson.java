package main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class WriteJson
{
    public static void main(String[] args) throws FileNotFoundException {
        JSONObject object = new JSONObject();

        // object
        object.put("firstName", "aan budi");
        object.put("lastName","setiawan");
        object.put("age", "25");

        String locationFile = "src/main/resources/latihan/jsonObject.json";
        PrintWriter printWriter = new PrintWriter(locationFile);
        printWriter.write(object.toJSONString());
        printWriter.flush();
        printWriter.close();
        System.out.println(object);

        // Object dalam object
        Map address = new HashMap();
        address.put("street","jl. Raya condet");
        address.put("city","jakarta timur");
        address.put("Prov","DKI Jakarta");
        address.put("kode post", 13640);

        JSONObject objectInObject = new JSONObject();
        objectInObject.put("address",address);

        locationFile = "src/main/resources/latihan/objectInObject.json";
        PrintWriter printObjectInObject = new PrintWriter(locationFile);
        printObjectInObject.write(objectInObject.toJSONString());
        printObjectInObject.flush();
        printObjectInObject.close();

        // Object array
        Map phoneNumber = new HashMap();
        phoneNumber.put("type","home");
        phoneNumber.put("number","12334");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(phoneNumber);

        Map phone = new HashMap();
        phone.put("type", "americano");
        phone.put("number","madagascar");

        jsonArray.add(phone);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phoneNumber",jsonArray);

        locationFile = "src/main/resources/latihan/array.json";
        PrintWriter pw = new PrintWriter(locationFile);
        pw.write(jsonObject.toJSONString());
        pw.flush();
        pw.close();
    }
}
