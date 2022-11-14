package lotto.ExceptionChecker;

import java.util.NoSuchElementException;

public class IntegerChecker {
    private final int number;

    public IntegerChecker(String input) {
        validate(input);
        this.number = Integer.parseInt(input);
    }

    public int numberReturn(){
        return number;
    }

    private void validate(String input){
        try {
            if (returnTrue(input) ){
                throw new IllegalArgumentException();
            }
        } catch (Exception IllegalArgumentException) {
            System.out.println("[ERROR] 숫자를 입력해주세요. ");
            IllegalArgumentException.printStackTrace();

            throw new NoSuchElementException();
        }

    }

    private boolean returnTrue (String input){
        try{
            Integer.parseInt(input);
            return false;
        }catch (Exception e){
            return true;
        }

    }


}
