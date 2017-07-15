package com.ziprealty.hackathon.zap;


import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by jamgale on 7/14/17.
 */
public class ApiRequestFactory {

    public ApiRequestFactory() {
    }

    public String sendGet(String sql, String pageNum, String pageSize) {

        List<NameValuePair> params = new LinkedList<>();

        URL urlObject;
        HttpURLConnection connection;
        String url = "https://api-qa.zaplabs.com/hackathon/getBySql?";

        try {
            writeParams(params,sql, pageNum, pageSize);

            String uriEncodedParams = URLEncodedUtils.format(params, "utf-8");
            url += uriEncodedParams;

            try {
                urlObject = new URL(url);
            }
            catch (MalformedURLException e) {
                return "Malformed URL:" + e.getMessage();
            }

            connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return "response code: " + responseCode  + " message:" + response.toString();
        }
        catch (IOException e) {
            return "IO Exception:" + e.getMessage();
        }


    }

    private void writeParams(List<NameValuePair> params, String sql, String pageNum, String pageSize) {

        if(sql != null) {
            params.add(new BasicNameValuePair("sql", sql));
        }
        if(pageNum != null) {
            params.add(new BasicNameValuePair("pageNum", pageNum));
        }
        if(pageSize != null) {
            params.add(new BasicNameValuePair("pageNum", pageSize));
        }
    }

}
