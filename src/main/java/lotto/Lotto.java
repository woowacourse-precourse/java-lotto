package lotto;

import java.util.List;
public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers){
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers){
        ExceptionCase exceptionCase = new ExceptionCase();
        try{
            exceptionCase.checkNumbersSize(numbers);
            exceptionCase.checkNumbersOverLap(numbers);
            exceptionCase.checkNumbersRange(numbers);
        }
        catch (Exception e){
            throw e;
        }
    }

}
