package http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Http {

    private static final String CREATE_USER = "https://jsonplaceholder.typicode.com/users/";
    private static final String CREATE_USER_ALL = "https://jsonplaceholder.typicode.com/users";
    private static  final String USER_NICKNAME = "https://jsonplaceholder.typicode.com/users?username=";
    private static final String DELETE_ID = "https://jsonplaceholder.typicode.com/users/3";

    public static void main(String[] args) throws IOException, InterruptedException {
        User user = new User(1, "Putin Huylo", "PNH", "putin@huylo.com",
                new Address("putin gandonovi4", "Fck. 666", "moskovVogne", "66554-2211",
                new Geo(-55.6677, 99.8877)),"(097) 546-44-33", "darkside.gom",
                new Company("Prigogin petushara", "Multi-layered client-server neural-net", "russian stupid people"));


//        final User createdUser = HttpSend.senPost(URI.create("https://jsonplaceholder.typicode.com/users"), user);
//        System.out.println(createdUser);

        // задание 4 работает
//        final List<User> userBy = HttpSend.senGetListUser(URI.create(CREATE_USER_ALL));
//        System.out.println(userBy);


        // задание 5 работает
//        final User userById = HttpSend.senGet(URI.create(CREATE_USER), 10);
//        System.out.println(userById);

//         задание 6 работает
//        final List<User> userByNickName = HttpSend.senGetUserNickName(URI.create(USER_NICKNAME), "Elwyn.Skiles");
//        System.out.println(userByNickName);

//        задание 3 работает
//        HttpSend.delete(DELETE_ID);

//        final User task3 = HttpSend.senPost(URI.create(CREATE_USER), user);
//        HttpSend.senGetListUser(URI.create(CREATE_USER));
//        System.out.println(task3);

        List<UserForTaskTwo> utf = HttpSend.allCommentsById(3);
        System.out.println(utf.get(0));
        System.out.println(HttpSend.allCommentsById(3).size());

    }
}
