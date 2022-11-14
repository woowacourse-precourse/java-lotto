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
    private static final String NumberNotInRange =" 숫자가 "+minNum+"~"+maxNum+"사이가 아닙니다";
    private static final String NumberNotStartWithZero =" 숫자가 "+ initNumber+"으로 시작합니다";
    private static final String charIsNotNumber = "잘못된 문자 입력입니다.";
    private static final String NumberIsMulti =" 중복된 숫자입니다";
    private final List<Integer> numbers;

    private WinningNumber(String string){
        List<Integer> numbers = StringToIntegerList(string);
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
                ifNumberAlreadyExist(numbers,temporaryInt);
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

    private void ifNumberAlreadyExist(List<Integer> numbers,int newNumber){
        if(numbers.contains(newNumber)){
            throw new IllegalArgumentException(ErrorResource.errorStart+NumberIsMulti);
        }
    }

    private void checkIfNumberInRange(int i){
        if(i<minNum ||i>maxNum){
            throw new IllegalArgumentException(ErrorResource.errorStart+NumberNotInRange);
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
        if(numbers.size() != Resoure.numberSize){
            throw new IllegalArgumentException();
        }
    }

}
