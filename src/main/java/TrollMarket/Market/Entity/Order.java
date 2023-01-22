package TrollMarket.Market.Entity;

import javax.persistence.*;

@Entity
@Table(name ="OrderTable")
public class  Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer OrderId;
    @Column(name = "TotalPay")
    private Double totalPay;

    public Order(){

    }

    public Order(Integer orderId, Double totalPay) {
        OrderId = orderId;
        this.totalPay = totalPay;
    }

    public Integer getOrderId() {
        return OrderId;
    }

    public void setOrderId(Integer orderId) {
        OrderId = orderId;
    }

    public Double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

}

