package trius.springframework.commands;


import com.mongodb.client.model.ValidationLevel;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ProductForm {
    private String id;

    @NotNull
    @NotEmpty(message = "Please enter the description!")
    private String name;

    @NotNull
    @NotEmpty(message = "Please enter the description!")
    private String description;

    @NotNull(message = "Please enter the stock")
    @DecimalMin(value = "0.00",inclusive = false,message = "Min value equals 0.01")
    @DecimalMax(value = "5000.00",inclusive = false,message = "Max value equals 5000.00")
    private BigDecimal price;

    @NotNull(message = "Please enter the stock")
    @Range(min = 1,max = 99999,message = "Stock number must be min 1, max 5 digit")
    private Integer stock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
