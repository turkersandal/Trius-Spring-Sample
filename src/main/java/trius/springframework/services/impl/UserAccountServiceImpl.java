package trius.springframework.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import trius.springframework.repositories.UserRepository;
import trius.springframework.security.UserAccount;
import trius.springframework.services.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserAccount findByUserId(String userId) {
        return userRepository.findByEmail(userId);
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        return userRepository.save(userAccount);
    }
}
