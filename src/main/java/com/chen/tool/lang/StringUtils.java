package com.chen.tool.lang;

/**
 * @ClassName: chen-tool
 * @Description: 字符串常用工具
 * @Author: 陈亮平
 * @Date: 2020/12/3 16:49
 * @Version: v1.0
 */
public class StringUtils {
    public static final int CHAR_NULL = 0;
    public static final int CHAR_BACKSPACE = 8;
    public static final int CHAR_BLANK = 32;

    /**
     * 去除所有空格
     *
     * @param str
     * @return
     */
    public static String trimAllBlank(String str) {
        int len = str.length();
        char[] val = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            if (!checkBlank(val[i])) {
                result.append(val[i]);
            }
        }
        return result.toString();
    }

    /**
     * 判断是否为空格
     *
     * @param c
     * @return
     */
    private static boolean checkBlank(char c) {
        return CHAR_BLANK == c || CHAR_BACKSPACE == c || CHAR_NULL == c;
    }

    /**
     * 拆分字符串
     *
     * @param str    源字符
     * @param target 拆分的目标
     * @return
     */
    public static String[] split(String str, String target) {
        return str.split(target);
    }
}
