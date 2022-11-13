package lotto.View;

public class UserException {
    public void IsIllegalArgumentException(String input) throws IllegalArgumentException{
        try{
            Double.parseDouble(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
