package lotto.domain;


import lotto.View.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class TargetNumbers {
    private TargetNumbers(List<String> input) {
        List<Integer> numbers=new ArrayList<>();
        isInputFormValid(input,numbers);
        Lotto game=new Lotto(numbers);
    }

    public static TargetNumbers getInstance(String input) {
        List<String> output=List.of(input.split(","));
        return new TargetNumbers(output);
    }

    private void isInputFormValid(List<String> input,List<Integer> output) throws IllegalArgumentException {
        for(String s:input){
            Boolean notDigit=s.chars().anyMatch(Character::isDigit);
            if(notDigit){
                throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER.getValue());
            }
            output.add(Integer.parseInt(s));
        }

    }

    public void isInstanceOf(Class<IllegalArgumentException> illegalArgumentExceptionClass) {

    }
}
