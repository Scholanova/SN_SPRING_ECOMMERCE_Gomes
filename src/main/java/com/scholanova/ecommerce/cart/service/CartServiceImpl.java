package com.scholanova.ecommerce.cart.service;

import com.scholanova.ecommerce.cart.entity.Cart;
import com.scholanova.ecommerce.cart.exception.CartException;
import com.scholanova.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartServiceImpl implements CartService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Cart addProductToCart(Cart cart, Long productId, int quantity) throws CartException {
        try{
            Cart currentCart = cart.addProduct(productRepository.findById(productId).get(),quantity);
            return currentCart;
        }
        catch (Exception e){
            throw new CartException("Ajout impossible au panier");
        }
    }

    @Override
    public Cart changeProductQuantity(Cart cart, Long productId, int quantity) {
        //TODO
        return null;
    }
}
