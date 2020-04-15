package com.scholanova.ecommerce.order.entity;

import com.scholanova.ecommerce.cart.entity.Cart;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {

    @Test
    public void checkout_ShouldSetTheDateAndTimeOfTodayInTheOrder(){
        //given
        Orders order = new Orders();
        //when
        order.checkout();
        //then
        assertThat(order.getIssueDate().equals(Calendar.getInstance().getTime().getTime()));
    }

    @Test
    public void checkout_ShouldSetOrderStatusToPending(){
        Orders order = new Orders();
        //when
        order.checkout();
        //then
        assertThat(order.getStatus().equals(OrderStatus.PENDING));
    }

    @Test
    public void checkout_ShouldThrowNotAllowedExceptionIfStatusIsClosed(){

    }

    @Test
    public void checkout_ShouldThrowIllegalArgExceptionIfCartTotalItemsQuantityIsZERO(){

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