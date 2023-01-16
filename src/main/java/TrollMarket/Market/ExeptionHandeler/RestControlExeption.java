package TrollMarket.Market.ExeptionHandeler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControlExeption {

    @ExceptionHandler
    public ResponseEntity<ErorRespon>handleExeption(NotAllowed e){

        ErorRespon erorRespon = new ErorRespon();
        erorRespon.setMassage(e.getMessage());
        erorRespon.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        erorRespon.setTimestamp();
        return new ResponseEntity<>(erorRespon,HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
