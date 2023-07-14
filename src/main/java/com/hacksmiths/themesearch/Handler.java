package com.hacksmiths.themesearch;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class Handler {

    public void handle () {
        try {
            String apiUrl = "https://api.openai.com/v1/completions";
            String apiKey = "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";

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setDoOutput(true);

            String requestBody = "{\n" +
                    "  \"model\": \"text-davinci-003\",\n" +
                    "  \"prompt\": \"get all the related items for birthday games\",\n" +
                    "  \"temperature\": 1,\n" +
                    "  \"max_tokens\": 64,\n" +
                    "  \"top_p\": 1.0,\n" +
                    "  \"frequency_penalty\": 0.0,\n" +
                    "  \"presence_penalty\": 0.0\n" +
                    "}";

            connection.getOutputStream().write(requestBody.getBytes());

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                System.out.println("Response: " + response.toString());
            } else {
                System.out.println("Error: " + responseCode);
            }

            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
