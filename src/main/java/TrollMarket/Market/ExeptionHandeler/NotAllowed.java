package TrollMarket.Market.ExeptionHandeler;

public class NotAllowed extends RuntimeException{
    public NotAllowed(){
        super();
    }
    public NotAllowed(String massage){
        super(massage);
    }
}
