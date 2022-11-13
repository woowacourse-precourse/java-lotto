package lotto;

public class Exceptions {
    private final String errorMessage;

    public Exceptions(String errorMessage){
        this.errorMessage = errorMessage;
        error();
    }
    public void error(){
        System.out.println("!!! Error Message !!!  " + errorMessage);
        try{
            throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }
}
