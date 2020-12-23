package com.chen.tool.lang;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: weijia-loan-boot
 * @Description: 参数解析器
 * @Author: 陈亮平
 * @Date: 2020/12/21 16:09
 * @Version: v1.0
 */
public class ParamUtils {
    /**
     * 解析json获取目标字段值
     *
     * @param result
     * @param field
     * @return
     */
    public static String analysis(String result, String field) {
        String[] fields = StringUtils.split(field, ".");
        for (String item : fields) {
            JSONObject object = JSON.parseObject(result);
            result = object.getString(item);
        }
        return result;
    }
}
