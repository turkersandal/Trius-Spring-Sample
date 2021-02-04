package trius.springframework.security;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "user")
public class UserAccount {
    @Id
    private String email;
    private String password;

    public UserAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserAccount() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
