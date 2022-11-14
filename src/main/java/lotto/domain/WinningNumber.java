package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private static final char rest = ',';
    private static final char zero = '0';
    private static final char nine = '9';
    private static final int maxNum = 45;
    private static final int initNumber = 0;
    private static final int minNum = 1;
    private static final int mulNum = 10;

    private final List<Integer> numbers;

    private WinningNumber(List<Integer> numbers){
        validate(numbers);
        this.numbers = numbers;
    }

    private List<Integer> StringToIntegerList(String string){
        List<Integer> numbers = new ArrayList<>();
        int temporaryInt = initNumber;
        for(int i=0;i<string.length();i++){
            char temporaryLetter = string.charAt(i);
            if(temporaryLetter == rest ){
                checkIfNumberInRange(temporaryInt);
                numbers.add(temporaryInt);
                temporaryInt = initNumber;
                continue;
            }
            checkIfCharIsNumber(temporaryLetter);
            checkIfNumberStartsWithZero(temporaryInt, temporaryLetter);
            temporaryInt = temporaryLetter *mulNum + (temporaryLetter -zero);
        }
        return numbers;
    }

    private void checkIfNumberInRange(int i){
        if(i<minNum ||i>maxNum){
            throw new IllegalArgumentException();
        }
    }
    private void checkIfNumberStartsWithZero(int temporaryNumber, char newNumber ){
        if(temporaryNumber == initNumber && newNumber == zero){
            throw new IllegalArgumentException();
        }
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
