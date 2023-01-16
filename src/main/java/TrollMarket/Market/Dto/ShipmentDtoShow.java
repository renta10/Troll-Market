package TrollMarket.Market.Dto;

public class ShipmentDtoShow {

    private Integer id;
    private String shipmentName;
    private double price;
    private boolean Service;

    public ShipmentDtoShow(){

    }

    public ShipmentDtoShow(Integer id, String shipmentName, double price, boolean service) {
        this.id = id;
        this.shipmentName = shipmentName;
        this.price = price;
        Service = service;
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
