package TrollMarket.Market.Dto;

import TrollMarket.Market.Validasi.UniqValidator;

public class RegisterDto {
    @UniqValidator(message = "Username dah ada cok")
    private String username;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNUmber;


    public RegisterDto(){}

    public RegisterDto(String username, String password, String role, String firstName,
                       String lastName, String address, String phoneNUmber) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNUmber = phoneNUmber;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
