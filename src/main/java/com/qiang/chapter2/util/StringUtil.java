package com.qiang.chapter2.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by liq on 2018/3/15.
 */
public final class StringUtil {

    public static boolean isEmpty(String str){
        if (str != null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
