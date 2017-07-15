package com.ziprealty.hackathon.util;

import java.util.List;

import static com.ziprealty.hackathon.util.Constants.MAX_STRING_LENGTH;

/**
 * Created by jamgale on 7/15/17.
 */
public class StringUtils {

    public static String condenseResponse(String sqlResponse) {
        StringBuilder retString = new StringBuilder(sqlResponse);
        if (retString.length() > 3000) {
            sqlResponse = retString.substring(0, MAX_STRING_LENGTH - 1);
        }
        return sqlResponse;
    }

}
