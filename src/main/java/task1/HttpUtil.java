package task1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class HttpUtil {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();


    public static void sendPost(URI uri, User user) {

        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        final HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            User user1 = GSON.fromJson(response.body(), User.class);
            System.out.println(user1 + "\n");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sendPut(URI uri, User user) {

        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .method("PUT", HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Metod 'PUT' response.statusCode() = " + response.statusCode());
            User user1 = GSON.fromJson(response.body(), User.class);
            System.out.println(user1 + "\n");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sendDelete(URI uri, User user) {

        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .method("DELETE", HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Metod 'DELETE' response.statusCode() = " + response.statusCode() + "\n");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sendGetWithListOfResults(URI uri) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            List<User> userList = GSON.fromJson(response.body(), new TypeToken<>() {
            }.getType());
            System.out.println(userList + "\n");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void sendGet(URI uri) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            assert response != null;
            System.out.println(GSON.fromJson(response.body(), new TypeToken<>() {
            }.getType()) + "\n");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
