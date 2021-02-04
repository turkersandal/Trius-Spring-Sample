package trius.springframework.commands.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddProductToBasket {

    @JsonProperty("user_email")
    String userEmail;
    @JsonProperty("product_id")
    String productId;

    public AddProductToBasket() {
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
}
