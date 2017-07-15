package com.ziprealty.hackathon.zap;

import org.junit.Test;

/**
 * Created by jamgale on 7/15/17.
 */

public class ApiRequestFactoryTest {


    @Test
    public void testApiRequestReturnsValidData() {

        ApiRequestFactory requestFactory = new ApiRequestFactory();

        String sql = "SELECT distinct(FIRST_NAME) from customer";
        String pageNum = "1";
        String perPage = "1000000";
    }

}
