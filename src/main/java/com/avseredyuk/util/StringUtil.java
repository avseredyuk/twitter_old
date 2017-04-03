package com.avseredyuk.util;

/**
 * Created by Anton_Serediuk on 4/3/2017.
 */
public class StringUtil {
    public static String firstLetterToLower(String string) {
        return Character.toLowerCase(string.charAt(0)) +
                (string.length() > 1 ? string.substring(1) : "");
    }
}
