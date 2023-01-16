package TrollMarket.Market.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Shipment")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="ShipmentName")
    private String shipmentName;
    @Column(name = "Price")
    private double price;

    @Column(name = "Service")
    private boolean Service;

    public Shipment() {
    }


    public Shipment(Integer id, String shipmentName, double price,boolean Service) {
        this.id = id;
        this.shipmentName = shipmentName;
        this.price = price;
        this.Service= Service;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShipmentName() {
        return shipmentName;
    }

    public void setShipmentName(String shipmentName) {
        this.shipmentName = shipmentName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isService() {
        return Service;
    }

    public void setService(boolean service) {
        Service = service;
    }
}
