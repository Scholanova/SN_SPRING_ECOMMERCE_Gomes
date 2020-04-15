package com.scholanova.ecommerce.order.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scholanova.ecommerce.cart.entity.Cart;
import com.scholanova.ecommerce.order.exception.IllegalArgException;
import com.scholanova.ecommerce.order.exception.OrderException;
import com.sun.xml.bind.v2.TODO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

@Entity(name="orders")
public class Orders {

    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column
    private String number;

    @Column
    private Date issueDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.CREATED;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id", referencedColumnName = "id")
    private Cart cart;

    public Orders() {
    }

    public static Orders createOrder(String number, Date issueDate, Cart cart){
        Orders entity = new Orders();
        entity.number = number;
        entity.issueDate = issueDate;
        entity.cart = cart;
        return entity;
    }

    public void checkout() throws OrderException, IllegalArgException {
        if(this.getCart().getCartItems().size()==0){
            throw new IllegalArgException("Panier vide !");
        }
        if(this.getStatus().equals(OrderStatus.CLOSED)){
            throw new OrderException("Commande cloturé !");
        }else{
            this.setStatus(OrderStatus.PENDING);
            this.setIssueDate(new Date(Calendar.getInstance().getTime().getTime()));
        }
    }

    public void getDiscount(){
        //TODO
    }

    public void getOrderPrice(){
        //TODO
    }

    public void close(){
        //TODO
    }


    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {return number;}

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getIssueDate() {return issueDate;}

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public OrderStatus getStatus() {return status;}

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Cart getCart() {return cart;}

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
