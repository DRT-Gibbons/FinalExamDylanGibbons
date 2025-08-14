//Name: Dylan Gibbons; Student Number: 200230810

package com.example.finalexamjavadylangibbons;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.lang.reflect.Type;


public class APIService {


    public static List<Customer> fetchCustomers() {
        Gson gson = new Gson();
        List<Customer> customers = null;
        try (InputStream is = APIService.class.getResourceAsStream("/customers.json");
             JsonReader reader = new JsonReader(new InputStreamReader(is))) {

            Type itemListType = new TypeToken<List<Customer>>() {}.getType();
            customers = gson.fromJson(reader, itemListType);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    //THE CODE BELOW WAS PREPPED BEFORE THE EXAM. UNFORTUNATELY, IT WAS ALL FOR NOUGHT!

    // Generic method for get request and parse JSON single object
//    public static <T> T fetchData(String apiUrl, Class<T> type) throws Exception {
//        URL url = new URL(apiUrl);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.connect();
//
//        if (conn.getResponseCode() != 200) {
//            throw new RuntimeException("HTTP error code: " + conn.getResponseCode());
//        }
//
//        try (InputStreamReader reader = new InputStreamReader(conn.getInputStream())) {
//            return new Gson().fromJson(reader, type);
//        }
//    }
//
//    Gson gson = new Gson();
//        try (FileReader reader = new FileReader("data.json")) {
//        MyDataModel data = gson.fromJson(reader, MyDataModel.class);
//        // Now 'data' contains the parsed JSON information
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    // Variant to fetch arrays from APIs that return JSON arrays
//    public static <T> T[] fetchDataArray(String apiUrl, Class<T[]> arrayType) throws Exception {
//        URL url = new URL(apiUrl);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.connect();
//
//        if (conn.getResponseCode() != 200) {
//            throw new RuntimeException("HTTP error code: " + conn.getResponseCode());
//        }
//
//        try (InputStreamReader reader = new InputStreamReader(conn.getInputStream())) {
//            return new Gson().fromJson(reader, arrayType);
//        }
//    }
}
