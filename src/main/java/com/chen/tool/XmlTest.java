package com.chen.tool;

import com.chen.tool.lang.XmlExercise;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author admin
 */
public class XmlTest extends XmlExercise {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "horizon");
        JSONArray jsonArray = new JSONArray();
        JSONObject dataJson = new JSONObject();
        jsonArray.add(jsonObject);
        dataJson.put("data", jsonArray);
        System.out.println(dataJson.toString());
        String xml = json2xml(dataJson.toString());
        System.out.println("xml:" + xml);
        String str = xml2json(xml);
        System.out.println("to_json" + str);
    }
}
