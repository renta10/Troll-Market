package TrollMarket.Market.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "History")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate date;
    @Column(name = "Quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product  product;
    @ManyToOne
    @JoinColumn(name = "BuyerID")
    private Buyer buyer;
    @ManyToOne
    @JoinColumn(name = "ShipmentID")
    private Shipment shipment;

    public History(){

    }

    public History(Integer id, LocalDate date, Integer quantity, Product product, Buyer buyer, Shipment shipment) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.product = product;
        this.buyer = buyer;
        this.shipment = shipment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
