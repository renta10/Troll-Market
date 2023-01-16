package TrollMarket.Market.ExeptionHandeler;

import java.time.LocalDateTime;

public class ErorRespon {
    private int status;
    private Object massage;
    private LocalDateTime timestamp;

    public ErorRespon (){

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getMassage() {
        return massage;
    }

    public void setMassage(Object massage) {
        this.massage = massage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp() {
        this.timestamp = LocalDateTime.now();
    }
}
