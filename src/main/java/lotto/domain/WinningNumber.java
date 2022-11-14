package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private static final char rest = ',';
    private static final char zero = '0';
    private static final char nine = '9';
    private static final int maxNum = 45;
    private static final int minNum = 0;
    private static final int mulNum = 10;

    private final List<Integer> numbers;

    private WinningNumber(List<Integer> numbers){
        validate(numbers);
        this.numbers = numbers;
    }

    private void checkIfCharIsNumber(char c){
        if(c<zero || c>nine){
            throw new IllegalArgumentException();
        }
    }

    private void validate(List<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException();
        }
    }

}
