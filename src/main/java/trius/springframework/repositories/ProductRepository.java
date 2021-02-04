package trius.springframework.repositories;

import trius.springframework.domain.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, String> {
}
