package trius.springframework.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import trius.springframework.domain.Order;
import trius.springframework.security.UserAccount;

public interface OrderRepository extends MongoRepository<Order, String> {
    Order findByUserAccount(UserAccount userAccount);
}
