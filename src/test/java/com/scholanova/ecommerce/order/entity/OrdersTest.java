package com.scholanova.ecommerce.order.entity;

import com.scholanova.ecommerce.cart.entity.Cart;
import com.scholanova.ecommerce.order.exception.IllegalArgException;
import com.scholanova.ecommerce.order.exception.NotAllowedException;
import com.scholanova.ecommerce.order.exception.OrderException;
import com.scholanova.ecommerce.product.entity.Product;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {

    @Test
    public void checkout_ShouldSetTheDateAndTimeOfTodayInTheOrder() throws NotAllowedException, IllegalArgException {
        //given
        Cart cart = new Cart();
        cart.addProduct(new Product().create("Vélo","Rapide",150.0f,1.0f,"EUR"),1);
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Orders order = Orders.createOrder("fr542168", date, cart);
        order.setId((long) 10);
        //when
        order.checkout();
        //then
        assertThat(order.getIssueDate().equals(Calendar.getInstance().getTime().getTime()));
    }

    @Test
    public void checkout_ShouldSetOrderStatusToPending() throws NotAllowedException, IllegalArgException {
        //given
        Cart cart = new Cart();
        cart.addProduct(new Product().create("Vélo","Rapide",150.0f,1.0f,"EUR"),1);
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Orders order = Orders.createOrder("fr542168", date, cart);
        order.setId((long) 10);
        //when
        order.checkout();
        //then
        assertThat(order.getStatus().equals(OrderStatus.CREATED));
    }

    @Test
    public void checkout_ShouldThrowNotAllowedExceptionIfStatusIsClosed(){
        //given
        Cart cart = new Cart();
        cart.addProduct(new Product().create("Vélo","Rapide",150.0f,1.0f,"EUR"),1);
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Orders order = Orders.createOrder("fr542168", date, cart);
        order.setId((long) 10);
        //when
        order.setStatus(OrderStatus.CLOSED);
        //then
        assertThrows(NotAllowedException.class,() -> order.checkout());
    }

    @Test
    public void checkout_ShouldThrowIllegalArgExceptionIfCartTotalItemsQuantityIsZERO() throws OrderException {
        //given
        Cart cart = new Cart();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Orders order = Orders.createOrder("fr542168", date, cart);
        order.setId((long) 10);
        //when

        //then
        assertThrows(IllegalArgException.class,() -> order.checkout());
    }

    @Test
    public void setCart_ShouldThrowNotAllowedExceptionIfStatusIsClosed(){

    }

    @Test
    public void createOrder_ShouldSetTheCartInTheOrder(){

    }

    @Test
    public void createOrder_ShouldSetStatusToCreated(){

    }

    @Test
    public void getDiscount_shouldReturnZEROIFCartTotalPriceIsLessThan100(){

    }

    @Test
    public void getDiscount_shouldReturn5percentIfCartTotalPriceIsMoreOrEqual100(){

    }

    @Test
    public void getOrderPrice_shouldReturnTotalPriceWithDiscount(){

    }

    @Test
    public void close_ShouldSetStatusToClose(){

    }

}