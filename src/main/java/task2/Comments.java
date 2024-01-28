package task2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comments {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    @Override
    public String toString() {
        return "Comments{ " +
                "postId=" + postId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}' ;
    }

}
