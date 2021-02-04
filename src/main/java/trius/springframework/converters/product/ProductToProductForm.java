package trius.springframework.converters.product;

import trius.springframework.commands.ProductForm;
import trius.springframework.domain.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {
    @Override
    public ProductForm convert(Product product) {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId().toHexString());
        productForm.setName(product.getName());
        productForm.setDescription(product.getDescription());
        productForm.setPrice(product.getPrice());
        productForm.setStock(product.getStock());
        return productForm;
    }
}
