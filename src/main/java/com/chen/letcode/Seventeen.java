package com.chen.letcode;

import java.util.*;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2020/12/2 15:53
 * @Version: v1.0
 */
public class Seventeen {
    public List<String> letterCombinations(String digits) {
        Map<String, List<String>> dictionaries = new HashMap<>(10);
        char letter = 'a';
        for (Integer i = 2; i < 10; ++i) {
            List<String> list = new ArrayList<>(3);
            list.add(String.valueOf(letter++));
            list.add(String.valueOf(letter++));
            list.add(String.valueOf(letter++));
            if ("7".equals(i)){
                list.add(String.valueOf(letter++));
            }
            dictionaries.put(String.valueOf(i), list);
        }
        char[] diChars = digits.toCharArray();
        Arrays.sort(diChars);
        List<String> resultList = new ArrayList<>();
        if (diChars.length > 0) {
            resultList = dictionaries.get(String.valueOf(diChars[0]));
        }
        for (int i = 1; i < diChars.length; i++) {
            int finalI = i;
            List<String> tmpList = new ArrayList<>();
            resultList.forEach(item -> {
                for (String ii : dictionaries.get(String.valueOf(diChars[finalI]))) {
                    tmpList.add(item + ii);
                }
            });
            resultList = tmpList;
        }
        return resultList;
    }
}
