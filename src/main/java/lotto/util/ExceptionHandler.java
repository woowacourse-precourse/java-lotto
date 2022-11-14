package lotto.util;

public class ExceptionHandler extends IllegalArgumentException{
    ExceptionHandler(){}

    ExceptionHandler(String message){
        super(message);
    }
}
