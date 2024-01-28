package task3;

import java.net.URI;
import java.util.List;

public class OutputOpenTasks {

    private static final String CREATE_USER_URL = "https://jsonplaceholder.typicode.com/users/1/todos";

    public static void main(String[] args) {

        List<User> stringList = OutputOpenTask.outputTaskIsCompleted(URI.create(CREATE_USER_URL));
        System.out.println("stringList = " + stringList);
    }
}
