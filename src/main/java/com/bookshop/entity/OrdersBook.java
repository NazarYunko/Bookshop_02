package com.bookshop.entity;

import javax.persistence.*;

/**
 * Created by Nazar on 19.06.2017.
 */
@Entity
public class OrdersBook {

    @EmbeddedId
    private OrdersBookId id;

    private int quantityBooksToBuy;

    public OrdersBook() {
    }

    public OrdersBook(OrdersBookId id, int quantityBooksToBuy) {
        this.id = id;
        this.quantityBooksToBuy = quantityBooksToBuy;
    }

    public OrdersBook (Book book, int quantityBooksToBuy) {
        this.id = new OrdersBookId(book);
        this.quantityBooksToBuy = quantityBooksToBuy;
    }


    public OrdersBookId getOrdersBookId() {
        return id;
    }

    public void setOrdersBookId(OrdersBookId ordersBookId) {
        this.id = ordersBookId;
    }

    public Book getBook() {
        return id.getBook();
    }

    public Orders getOrders() {
        return id.getOrders();
    }

    public int getQuantityBooksToBuy() {
        return quantityBooksToBuy;
    }

    public void setQuantityBooksToBuy(int quantityBooksToBuy) {
        this.quantityBooksToBuy = quantityBooksToBuy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersBook that = (OrdersBook) o;

        if (quantityBooksToBuy != that.quantityBooksToBuy) return false;
        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + quantityBooksToBuy;
        return result;
    }
}
