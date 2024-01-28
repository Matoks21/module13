package task2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import task3.User;


import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class OutputComment {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();


    public static void sendGetWithListOfResults(URI uri) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        assert response != null;
        String userList = response.body();
        writeCommentsToFile(userList);
    }

    private static void writeCommentsToFile(String body) {
        try (FileWriter fileWriter = new FileWriter("user-X-post-Y-comments.json")) {
            fileWriter.write(body);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}






