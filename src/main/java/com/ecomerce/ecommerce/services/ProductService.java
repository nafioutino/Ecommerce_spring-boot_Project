package com.ecomerce.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.ecommerce.model.Product;
import com.ecomerce.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {
      @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Produit non trouvé"));
        return product;
    }

    public Product createProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct;
    }

    public Product updateProduct(Long id, Product product) {
        Product productToUpdate = productRepository
                .findById(id) // cherche l'utilisateur correspondant à l'id fourni
                .orElseThrow(() -> new RuntimeException("Product avec l'id " + id + " non trouvé")); // renvoie une
                                                                                                  // exception si
                                                                                                  // l'utilisateur n'est
                                                                                                  // pas trouvé
       productToUpdate.setName(product.getName());
       productToUpdate.setPrice(product.getPrice());
       productToUpdate.setCategories(product.getCategories());
       productToUpdate.setOrderItems(product.getOrderItems());
        return productToUpdate;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id); // supprime l'utilisateur correspondant à l'id fourni
    }
    
}
