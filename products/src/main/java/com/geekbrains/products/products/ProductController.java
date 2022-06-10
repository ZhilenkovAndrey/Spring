package com.geekbrains.products.products;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> showProductList() {
        return productRepository.getProductList(productRepository.getProducts());
    }

    @PostMapping("/products")
    public void addNewProductToProductList(@RequestBody Product product) {
        productRepository.add(product);
    }

    @DeleteMapping("/products/del/{obj}")
    public void deleteProductFromProductList(@RequestBody Product product) {
        productRepository.delete(product);
    }

    @PutMapping("/products/upd/{id}/{obj}")
    public void updateProductTitleInProductList(@PathVariable Long id,
                                                @PathVariable String newTitle) {
        productRepository.update(id, newTitle);
    }

    @PutMapping("/products/upd/{id}/{obj}")
    public void updateProductCostInProductList(@PathVariable Long id,
                                               @PathVariable Double newCost) {
        productRepository.update(id, newCost);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    @GetMapping("/products/{obj}")
    public Product getProductByTitle(@PathVariable String title) {
        return productRepository.findByTitle(title);
    }
}
