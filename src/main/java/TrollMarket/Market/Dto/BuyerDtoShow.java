package TrollMarket.Market.Dto;

public class BuyerDtoShow {

    private String fullName;
    private String address;
    private String phoneNUmber;
    private double wallet;

    public BuyerDtoShow() {
    }

    public BuyerDtoShow(String fullName, String address, String phoneNUmber, double wallet) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNUmber = phoneNUmber;
        this.wallet = wallet;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNUmber() {
        return phoneNUmber;
    }

    public void setPhoneNUmber(String phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
}
