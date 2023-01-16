package TrollMarket.Market.Dto;

public class SellerDtoShow {
    private Integer id;
    private String fullName;
    private String address;
    private String phoneNUmber;
    private Double wallet;

    public SellerDtoShow (){

    }
    public SellerDtoShow(Integer id, String firstName, String lastName, String address, String phoneNUmber, Double wallet) {
        this.id = id;
        this.fullName = firstName + " " + lastName;
        this.address = address;
        this.phoneNUmber = phoneNUmber;
        this.wallet = wallet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
