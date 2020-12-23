package com.chen.tool;

import com.chen.tool.arithmometer.ArithmeticTool;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 */
public class ChenToolApplication {

    public static void main(String[] args) {
        Map<String, String> map = new Hashtable();
        System.out.println(ArithmeticTool.calculateExp("{\"params\":\"{\\\"modelId\\\":\\\"ff8080817544c72f01754f6d33f3107d\\\"}\"}"));
    }

}
