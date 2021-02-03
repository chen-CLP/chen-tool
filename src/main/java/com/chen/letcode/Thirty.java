package com.chen.letcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2021/1/29 15:09
 * @Version: v1.0
 */
public class Thirty {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words.length == 0) {
            return list;
        }
        int len = words[0].length();
        for (String word : words) {
            if (word.length() != len) {
                return list;
            }
        }
        for (int i = 0; i < s.length(); ++i) {

        }
        return null;
    }
}
