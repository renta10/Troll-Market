package TrollMarket.Market.Dto;

import TrollMarket.Market.Validasi.UniqValidator;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class RegisterDto {
    @NotNull(message = "tidak boleh kosong")
    @UniqValidator(message = "Username dah ada cok")
    private String username;
    @Length(min = 8,message = "minimun 8 chart")
    @NotNull(message = "password Not Null")
    private String password;
    @NotNull(message = "choose your role")
    private String role;
    @NotNull(message = "firstname Not Null")
    private String firstName;
    @NotNull(message = "lastname Not Null")
    private String lastName;
    @NotNull(message = " Address Not Null")
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
