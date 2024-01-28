package task2;

import java.io.IOException;
import java.net.URI;

public class OutputComments {
    private static final String CREATE_USER_URL = "https://jsonplaceholder.typicode.com/posts/10/comments";

    public static void main(String[] args) throws IOException, InterruptedException {
        OutputComment.sendGetWithListOfResults(URI.create(CREATE_USER_URL));

    }
}
