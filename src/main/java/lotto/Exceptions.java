package lotto;

public class Exceptions {

    public Exceptions(){
        System.out.println("error 실행");
        error();
    }
    public void error(){
        try{
            throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }
}
