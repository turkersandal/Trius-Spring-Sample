package trius.springframework.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import trius.springframework.commands.ProductForm;
import trius.springframework.controllers.base.BaseController;
import trius.springframework.converters.product.ProductToProductForm;
import trius.springframework.domain.Basket;
import trius.springframework.domain.Order;
import trius.springframework.domain.Product;
import trius.springframework.security.UserAccount;
import trius.springframework.services.BasketService;
import trius.springframework.services.OrderService;
import trius.springframework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import trius.springframework.services.UserAccountService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class ProductController extends BaseController {
    private ProductService productService;

    private ProductToProductForm productToProductForm;

    @Autowired
    UserAccountService userAccountService;
    @Autowired
    OrderService orderService;
    @Autowired
    BasketService basketService;

    @Autowired
    public void setProductToProductForm(ProductToProductForm productToProductForm) {
        this.productToProductForm = productToProductForm;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"/product/list", "/product"})
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        model.addAttribute("userid",getAuthentication().getName());
        return "product/list";
    }

    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "product/show";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Product product = productService.getById(id);
        ProductForm productForm = productToProductForm.convert(product);

        model.addAttribute("productForm", productForm);
        return "product/productform";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("productForm", new ProductForm());
        return "product/productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid ProductForm productForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product/productform";
        }

        Product savedProduct = productService.saveOrUpdateProductForm(productForm);

        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        productService.delete(id);
        return "redirect:/product/list";
    }

    @GetMapping("/order-list")
    public String getOrderList(Model model){

        List<Order> orderList = orderService.getOrderList();
        model.addAttribute("orderList",orderList);

        return "order/order-list";
    }

    @PostMapping ("/order/{id}")
    public String addOrder(@PathVariable("id")String userId, RedirectAttributes ra){

        UserAccount userAccount = userAccountService.findByUserId(userId);
        Basket basket = basketService.getBasketByUser(userAccount);
        Order order = new Order(userAccount,basket.getProductList());
        orderService.saveOrder(order);
        basketService.clearBasket(userAccount);

        return "redirect:/product/list";

    }


}
