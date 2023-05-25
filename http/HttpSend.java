package http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpSend {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    //задание 5
//    public static User senGet(URI uri, int id) throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(uri + "/" + id))
//                .GET()
//                .build();
//
//        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
//        response.body();
//
//    (может надо удалить)    User user = GSON.fromJson(response.body(), User.class);
//        return user;
//
//    }

            // задание 6 работает
//    public static List<User> senGetUserNickName(URI uri, String nickName) throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(uri + nickName))
//                .GET()
//                .build();
//
//        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
//        response.body();
//
//        List<User> user = GSON.fromJson(response.body(), new TypeToken<List<User>>(){}.getType());
//        return user;
//
//    }

    //задание 3
//    public static void delete (String uri) throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(uri))
//                .header("Content-Type", "application/json")
//                .DELETE()
//                .build();
//
//        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.statusCode());
//
//
//    }

    public static User senPost (URI uri, User user) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
    }

    // задание 4 работает
//    public static List<User> senGetListUser(URI uri) throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(uri)
//                .GET()
//                .build();
//
//        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
//        response.body();
//
//        List<User> users = GSON.fromJson(response.body(), new TypeToken<List<User>>(){}.getType());
//        return users;
//    }
}
