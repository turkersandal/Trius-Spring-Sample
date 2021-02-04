package trius.springframework.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trius.springframework.commands.dto.AddProductToBasket;
import trius.springframework.converters.product.ProductToProductForm;
import trius.springframework.domain.Basket;
import trius.springframework.domain.Product;
import trius.springframework.security.UserAccount;
import trius.springframework.services.BasketService;
import trius.springframework.services.ProductService;
import trius.springframework.services.UserAccountService;

@RestController
@RequestMapping("/api/basket")
public class BasketRestController {

    @Autowired
    BasketService basketService;
    @Autowired
    ProductService productService;
    @Autowired
    UserAccountService userAccountService;
    @Autowired
    private ProductToProductForm productToProductForm;

    @GetMapping("/{id}")
    public ResponseEntity<?> getBasket(@PathVariable("id")String uid){

        try {
            Basket basket = basketService.getBasketByUser(userAccountService.findByUserId(uid));
            return new ResponseEntity<Basket>(basket,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String >("Sepet getirilemedi.",HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/clear/{id}")
    public ResponseEntity<?> clearBasket(@PathVariable("id")String uid ){

        try {
            basketService.clearBasket(userAccountService.findByUserId(uid));
            return new ResponseEntity<String>("Sepet temizlendi...",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("",HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> addProductToBasket(@RequestBody AddProductToBasket addProductToBasket){
        try {
            Product product = productService.getById(addProductToBasket.getProductId());
            UserAccount userAccount = userAccountService.findByUserId(addProductToBasket.getUserEmail());

            if(product.getStock() > 0){
                Basket basket = basketService.addProductToBasket(product,userAccount);
                product.setStock((product.getStock()-1));
                productService.saveOrUpdateProductForm(productToProductForm.convert(product));
                return new ResponseEntity<Basket>(basket, HttpStatus.OK);
            }else {
                return new ResponseEntity<String>("Ürün stoğu bulunmuyor",HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<String>("Maalesef ürün eklenemedi...", HttpStatus.BAD_REQUEST);
        }

    }

}
