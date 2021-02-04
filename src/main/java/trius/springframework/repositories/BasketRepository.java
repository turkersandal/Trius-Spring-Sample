package trius.springframework.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import trius.springframework.domain.Basket;
import trius.springframework.security.UserAccount;

public interface BasketRepository extends MongoRepository<Basket, UserAccount> {

    Basket findByUserAccount(UserAccount userAccount);
}
