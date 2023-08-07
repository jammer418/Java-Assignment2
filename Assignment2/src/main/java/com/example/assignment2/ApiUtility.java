package com.example.assignment2;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ApiUtility {

    public static String submitLocation(String latitude, String longitude) throws IOException, InterruptedException {
        String uri= "https://maps.googleapis.com/maps/api/elevation/json?locations=" + latitude + "%2C" + longitude + "&key=AIzaSyBsNqej9U5UbX2KkOZiPo8Tvn1kXBGxBMo";
        String result = null;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String responseJSON = response.body();
        Gson gson = new Gson();
        ApiResponse apiResponse = gson.fromJson(responseJSON, ApiResponse.class);
        for (Elevation elevation:apiResponse.getResults()
        ){
            result = elevation.getElevation();
        }
        return result;
    }
}
