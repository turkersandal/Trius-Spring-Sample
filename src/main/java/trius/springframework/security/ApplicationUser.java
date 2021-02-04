package trius.springframework.security;

import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;


public class ApplicationUser extends  User {
    public ApplicationUser(String email, String password) {
       super(email,password, new ArrayList<>());
    }
}
