package trius.springframework.security;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import trius.springframework.domain.Basket;
import trius.springframework.domain.Order;
import trius.springframework.domain.Product;
import trius.springframework.repositories.UserRepository;
import trius.springframework.services.BasketService;
import trius.springframework.services.OrderService;
import trius.springframework.services.ProductService;
import trius.springframework.services.UserAccountService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitializeUsers {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserAccountService userAccountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    BasketService basketService;

    @PostConstruct
    public void init(){
        //userRepository.save(new UserAccount("turker@gmail.com", passwordEncoder.encode("123456")));
        //Basket basket = new Basket(userRepository.findByEmail("turker@gmail.com"),new ArrayList<Product>());
        //basketService.save(basket);

    }

}
