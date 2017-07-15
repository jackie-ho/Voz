package com.ziprealty.hackathon.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jamgale on 7/15/17.
 */

public class StringUtilsTest {


    @Test
    public void testStringUtils_CondenseStringCondensesString() {

        int length = 4000;
        StringBuilder outputBuffer = new StringBuilder(length);
        for (int i = 0; i < length; i++){
            outputBuffer.append("a");
        }
        String longString = outputBuffer.toString();

        Assert.assertEquals(longString.length(), 4000);

        String shortString = StringUtils.condenseResponse(longString);
        Assert.assertEquals(shortString.length(), 2999);

    }

}
