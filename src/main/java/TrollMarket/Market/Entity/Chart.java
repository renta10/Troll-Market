package TrollMarket.Market.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Chart")
public class Chart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChart;

    @Column(name = "Quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "Buyer_Id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "Product_ID")
    Product product;

    @ManyToOne
    @JoinColumn(name = "Shipment_ID")
    Shipment shipment;
    @ManyToOne
    @JoinColumn(name = "OrderId")
    private Order order;

    public Chart() {
    }

    public Chart(Integer idChart, Integer quantity, Buyer buyer, Product product, Shipment shipment) {
        this.idChart = idChart;
        this.quantity = quantity;
        this.buyer = buyer;
        this.product = product;
        this.shipment = shipment;
    }

    public Chart(Integer idChart, Integer quantity,  Buyer buyer, Product product, Shipment shipment, Order order) {
        this.idChart = idChart;
        this.quantity = quantity;
        this.buyer = buyer;
        this.product = product;
        this.shipment = shipment;
        this.order = order;
    }

    public Integer getIdChart() {
        return idChart;
    }

    public void setIdChart(Integer idChart) {
        this.idChart = idChart;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
