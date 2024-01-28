package task1;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {

    private int id;
    private String name;
    private String username;
    private String email;
    private Adress address;
    private String phone;
    private String website;
    private Company company;

    public User(int id, String name, String username, String email, Adress address,
                String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }


    @Getter
    @Setter
    static class Adress {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

    }

    @Getter
    @Setter
    static class Geo {
        private String lat;
        private String lng;


    }

    @Getter
    @Setter
    static class Company {
        private String name;
        private String catchPhrase;
        private String bs;

    }
}