package trius.springframework.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trius.springframework.domain.Basket;
import trius.springframework.domain.Product;
import trius.springframework.repositories.BasketRepository;
import trius.springframework.security.UserAccount;
import trius.springframework.services.BasketService;
import trius.springframework.services.UserAccountService;


@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Override
    public Basket getBasketByUser(UserAccount userAccount) {
        return basketRepository.findByUserAccount(userAccount);
    }

    @Override
    public Basket addProductToBasket(Product product, UserAccount userAccount) {
        List<Product> productList = new ArrayList<Product>();
        Basket basket = basketRepository.findByUserAccount(userAccount);
        productList = basket.getProductList();
        productList.add(product);
        basket.setProductList(productList);
        basketRepository.save(basket);

        return basket;
    }

    @Override
    public Basket save(Basket basket) {
        return basketRepository.save(basket);
    }

    @Override
    public void clearBasket(UserAccount userAccount) {

        Basket basket = basketRepository.findByUserAccount(userAccount);
        basket.setProductList(new ArrayList<Product>());
        basketRepository.save(basket);

    }
}
