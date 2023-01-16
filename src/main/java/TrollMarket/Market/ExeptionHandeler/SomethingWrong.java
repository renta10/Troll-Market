package TrollMarket.Market.ExeptionHandeler;

public class SomethingWrong extends RuntimeException{
    public SomethingWrong(){
        super();
    }
    public SomethingWrong(String massage){
        super(massage);
    }
}
