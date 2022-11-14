package lotto.util;

public class ExceptionHandler extends IllegalArgumentException{
    ExceptionHandler(){}

    ExceptionHandler(String message){
        super("[ERROR]" + message);
    }

    public void setMessage(String message){
        throw new ExceptionHandler(message);
    }
}
