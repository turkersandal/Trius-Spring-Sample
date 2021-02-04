package trius.springframework.domain;



import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import trius.springframework.security.UserAccount;

@Document(collection = "basket")
public class Basket {

    @Id
    UserAccount userAccount;
    List<Product> productList;

    public Basket(UserAccount userAccount, List<Product> productList) {
        this.userAccount = userAccount;
        this.productList = productList;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<Product> getProductList() {
        return productList;
    }
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
