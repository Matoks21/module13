package task1;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import static java.lang.String.format;


public class HttpUtils {

    private static final String CREATE_USER_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String CREATE_USER_URL_ID = "https://jsonplaceholder.typicode.com/users/9";
    private static final String CREATE_USER_URL_USERNAME = "https://jsonplaceholder.typicode.com/users?username=Karianne";

    public static void main(String[] args) throws IOException, InterruptedException {

        User user = createDefaultUser();

        HttpUtil.sendPost(URI.create(CREATE_USER_URL), user);

        HttpUtil.sendPut(URI.create(CREATE_USER_URL + "/" + user.getId()), user);

        HttpUtil.sendGetWithListOfResults(URI.create(CREATE_USER_URL));

        HttpUtil.sendDelete(URI.create(CREATE_USER_URL + "/" + user.getId()), user);

        HttpUtil.sendGet(URI.create(format(CREATE_USER_URL_ID, user.getId())));


        HttpUtil.sendGet(URI.create(format(CREATE_USER_URL_USERNAME, user.getUsername())));

    }

    private static User createDefaultUser() {

        return new User(1, "Hanna", "Montana", "river@gmail.com", null, "256545454" +
                "54", "sky.com", null);
    }


}
