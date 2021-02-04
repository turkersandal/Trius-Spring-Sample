package trius.springframework.services;

import trius.springframework.domain.Basket;
import trius.springframework.domain.Product;
import trius.springframework.security.UserAccount;

public interface BasketService {

    Basket getBasketByUser(UserAccount userAccount);
    Basket addProductToBasket(Product product, UserAccount userAccount);
    Basket save(Basket basket);
    void clearBasket(UserAccount userAccount);
}
