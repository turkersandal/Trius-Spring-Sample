package trius.springframework.repositories;

import trius.springframework.security.ApplicationUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import trius.springframework.security.UserAccount;

public interface UserRepository extends MongoRepository<UserAccount, String> {

    UserAccount findByEmail(String email);
}
