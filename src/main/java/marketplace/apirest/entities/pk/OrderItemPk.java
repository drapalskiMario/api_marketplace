package marketplace.apirest.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import marketplace.apirest.entities.Order;
import marketplace.apirest.entities.Product;

@Embeddable
public class OrderItemPk implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderItemPk)) {
            return false;
        }
        OrderItemPk orderItemPk = (OrderItemPk) o;
        return Objects.equals(order, orderItemPk.order) && Objects.equals(product, orderItemPk.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
