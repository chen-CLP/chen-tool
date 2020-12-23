package com.chen.tool.arithmometer;

import org.springframework.util.StringUtils;

import java.util.*;


/**
 * @ClassName: chen-tool
 * @Description: 简单的四则运算表达式
 * @Author: 陈亮平
 * @Date: 2020/11/25 11:21
 * @Version: v1.0
 */
public final class ArithmeticTool {
    /**
     * 操作符优先级
     */
    protected static Map<String, Integer> operatorSymbol;
    /**
     *
     */
    protected static String ADD = "+";
    /**
     *
     */
    protected static String SUBTRACT = "-";
    /**
     *
     */
    protected static String MULTIPLY = "*";
    /**
     *
     */
    protected static String DIVIDE = "/";
    /**
     *
     */
    protected static String BRACKET_LEFT = "(";
    /**
     *
     */
    protected static String BRACKET_RIGHT = ")";
    /**
     *
     */
    protected static String END_SYMBOL = "#";

    /**
     *添加操作符的优先级
     */
    static {
        operatorSymbol = new HashMap<>();
        operatorSymbol.put(ADD, 1);
        operatorSymbol.put(SUBTRACT, 1);
        operatorSymbol.put(MULTIPLY, 2);
        operatorSymbol.put(DIVIDE, 2);
        operatorSymbol.put(BRACKET_LEFT, 3);
        operatorSymbol.put(BRACKET_RIGHT, 3);
    }

    /**
     * 表达式求值
     *
     * @param exp
     * @return
     */
    public final static Double calculateExp(String exp) {
        if (StringUtils.isEmpty(exp)) {
            return 0.00;
        }
        exp = StringUtils.trimAllWhitespace(exp);
        String firstSymbol = exp.substring(0, 1);
        if (SUBTRACT.equals(firstSymbol)) {
            exp = "0" + exp;
        }
        exp = exp + END_SYMBOL;
        return execute(analysis(exp));
    }

    /**
     * 进行解析
     *
     * @param exp
     * @return
     */
    public static List<String> analysis(String exp) {
        List<String> data = new ArrayList<>();
        Stack<String> stackValue = new Stack<>();
        Stack<String> stackSymbol = new Stack<>();
        String strValue = "";
        for (Character i : exp.toCharArray()) {
            if (checkSymbol(i.toString()) || END_SYMBOL.equals(i.toString())) {
                if (!strValue.isEmpty()) {
                    stackValue.add(strValue);
                    strValue = "";
                }
                if (checkSymbol(i.toString())) {
                    addSymbol(stackSymbol, stackValue, String.valueOf(i));
                }
            } else {
                strValue += i;
            }
        }
        while (!stackSymbol.isEmpty()) {
            stackValue.add(stackSymbol.pop());
        }
        data.addAll(stackValue);
        return data;
    }

    protected static void addSymbol(Stack<String> stackSymbol, Stack<String> stackValue, String symbol) {
        if (BRACKET_RIGHT.equals(symbol)) {
            while (!stackSymbol.empty() && !BRACKET_LEFT.equals(stackSymbol.peek())) {
                stackValue.add(stackSymbol.pop());
            }
            if (stackSymbol.empty()) {
                throw new IllegalArgumentException("()不匹配");
            }
            stackSymbol.pop();
        } else if (stackSymbol.empty()
                || BRACKET_LEFT.equals(symbol)
                || BRACKET_LEFT.equals(stackSymbol.peek())
                || compareSymbol(symbol, stackSymbol.peek())) {
            stackSymbol.add(symbol);
        } else if (!compareSymbol(symbol, stackSymbol.peek())) {
            stackValue.add(stackSymbol.pop());
            addSymbol(stackSymbol, stackValue, symbol);
        } else {
            throw new IllegalArgumentException("该操作符不在识别范围内=-*/()" + symbol);
        }
    }

    /**
     * @param data
     * @return
     */
    protected static Double execute(List<String> data) {
        Stack<Double> stackValue = new Stack<>();
        for (String i : data) {
            if (!checkSymbol(i)) {
                stackValue.add(Double.valueOf(i));
            } else {
                execute(i, stackValue);
            }
        }
        if (stackValue.empty()) {
            throw new IllegalArgumentException("数据格式不正确");
        }
        return stackValue.peek();
    }

    /**
     * 计算数据
     *
     * @param i
     * @param stackValue
     */
    private static void execute(String i, Stack<Double> stackValue) {
        if (stackValue.size() < 2) {
            throw new IllegalArgumentException("数据格式不正确");
        }
        Double a = stackValue.pop();
        Double b = stackValue.pop();
        Double c = execute(i, b, a);
        stackValue.add(c);
    }

    /**
     * 数值计算
     *
     * @param i
     * @param a
     * @param b
     * @return
     */
    private static Double execute(String i, Double a, Double b) {
        if (ADD.equals(i)) {
            return a + b;
        } else if (SUBTRACT.equals(i)) {
            return a - b;
        } else if (MULTIPLY.equals(i)) {
            return a * b;
        } else if (DIVIDE.equals(i)) {
            return a / b;
        } else {
            throw new IllegalArgumentException("数据格式不对" + i + "不可计算的操作符");
        }
    }

    /**
     * 判断是否为操作符
     *
     * @param symbol
     * @return
     */
    protected static boolean checkSymbol(String symbol) {
        return operatorSymbol.get(symbol) != null;
    }

    /**
     * 比较运算符
     *
     * @param a
     * @param b
     * @return
     */
    protected static boolean compareSymbol(String a, String b) {
        Integer aV = operatorSymbol.get(a);
        Integer bV = operatorSymbol.get(b);
        return aV > bV;
    }
}
