package TrollMarket.Market.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailId;
    @Column(name = "SubTotal")
    private Double Subtotal;
    @Column(name = "OrderDetailDate")
    private LocalDate orderDetailDate;

    @ManyToOne
    @JoinColumn(name = "id_Order")
    private Order order;

    public OrderDetail(){}


    public OrderDetail(Integer orderDetailId, Double subtotal, LocalDate orderDetailDate) {
        this.orderDetailId = orderDetailId;
        Subtotal = subtotal;
        this.orderDetailDate = orderDetailDate;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(Double subtotal) {
        Subtotal = subtotal;
    }

    public LocalDate getOrderDetailDate() {
        return orderDetailDate;
    }

    public void setOrderDetailDate(LocalDate orderDetailDate) {
        this.orderDetailDate = orderDetailDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
