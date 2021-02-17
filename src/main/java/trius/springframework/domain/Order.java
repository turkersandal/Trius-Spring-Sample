package trius.springframework.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.DeleteMapping;
import trius.springframework.security.UserAccount;

import java.util.Date;
import java.util.List;

@Document(collection = "order")
public class Order {

    @Id
    private ObjectId orderId;
    private UserAccount userAccount;
    private List<Product> productList;
    private Date orderDate;

    public Order(UserAccount userAccount, List<Product> productList) {
        this.userAccount = userAccount;
        this.productList = productList;
    }

    public ObjectId getOrderId() {
        return orderId;
    }
    public void setOrderId(ObjectId orderId) {
        this.orderId = orderId;
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

    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
