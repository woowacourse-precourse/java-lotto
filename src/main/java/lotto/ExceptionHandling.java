package lotto;

public class ExceptionHandling {

    public void notDivideException(long amount){
        if(amount % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }

}
