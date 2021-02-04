package trius.springframework.services;

import org.springframework.security.core.userdetails.User;
import trius.springframework.security.UserAccount;

public interface UserAccountService {

    UserAccount findByUserId(String userId);
    UserAccount save(UserAccount userAccount);
}
