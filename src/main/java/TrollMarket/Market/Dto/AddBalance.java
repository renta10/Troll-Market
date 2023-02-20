package TrollMarket.Market.Dto;

public class AddBalance {
    private Double balance;

    public AddBalance(){}

    public AddBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
