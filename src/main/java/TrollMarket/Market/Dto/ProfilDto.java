package TrollMarket.Market.Dto;

import TrollMarket.Market.Entity.Buyer;

import java.text.NumberFormat;
import java.util.Locale;

public class ProfilDto {
    private String firstName;
    private String LastName;
    private String name;
    private String role;
    private String address;
    private String balance;

    public ProfilDto() {
    }

//    public ProfilDto(String name, String role, String address, String balance) {
//        this.name = name ;
//        this.role = role;
//        this.address = address;
//        this.balance = balance;
//    }

    public ProfilDto(String firstName, String lastName,  String role, String address, String balance) {
        this.firstName = firstName;
        this.LastName = lastName;
        this.name = firstName + "  " + lastName;
        this.role = role;
        this.address = address;
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
