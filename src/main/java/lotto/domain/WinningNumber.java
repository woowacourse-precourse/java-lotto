package lotto.domain;

import lotto.resource.ErrorResource;
import lotto.resource.Resource;

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
    private static final String NumberStartWithZero =" 숫자가 "+ initNumber+"으로 시작합니다";
    private static final String NumberIsMulti =" 중복된 숫자입니다";
    private static final String bonusNumberAlreadyIn =" 당첨번호에 보너스 넘버가 이미 있습니다";

    private final List<Integer> numbers;
    private int bonusNumber;

    public WinningNumber(String string,int bonusNumber){
        List<Integer> numbers = StringToIntegerList(string);
        validate(numbers);
        this.numbers = numbers;
        setBonusNumber(bonusNumber);
    }

    public int getBonusNumber(){
        return this.bonusNumber;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
    public List<Integer> StringToIntegerList(String string){
        List<Integer> numbers = new ArrayList<>();
        int temporaryNumber = initNumber;
        for(int i=0;i<string.length();i++){
            char temporaryLetter = string.charAt(i);

            if(temporaryLetter == rest){
                numberValidate(numbers, temporaryNumber);
                temporaryNumber = initNumber;
                continue;
            }
            temporaryNumber = getTemporaryNumber(temporaryNumber, temporaryLetter);
            if(i== string.length()-1){
                numberValidate(numbers, temporaryNumber);
            }
        }
        return numbers;
    }

    public void numberValidate(List<Integer> numbers, int temporaryNumber) {
        checkIfNumberInRange(temporaryNumber);
        ifNumberAlreadyExist(numbers, temporaryNumber);
        numbers.add(temporaryNumber);
    }

    public int getTemporaryNumber(int temporaryNumber, char temporaryLetter) {
        checkIfCharIsNumber(temporaryLetter);
        checkIfNumberStartsWithZero(temporaryNumber, temporaryLetter);
        temporaryNumber = temporaryNumber *mulNum + (temporaryLetter -zero);
        return temporaryNumber;
    }

    public void ifNumberAlreadyExist(List<Integer> numbers,int newNumber){
        if(numbers.contains(newNumber)){
            throw new IllegalArgumentException(ErrorResource.errorStart+NumberIsMulti);
        }
    }

    public void checkIfNumberInRange(int i){
        if(i<minNum || i>maxNum){
            throw new IllegalArgumentException(ErrorResource.errorStart+NumberNotInRange +i);
        }
    }
    public void checkIfNumberStartsWithZero(int temporaryNumber, char newNumber ){
        if(temporaryNumber == initNumber && newNumber == zero){
            throw new IllegalArgumentException(ErrorResource.errorStart+ NumberStartWithZero);
        }
    }

    public void checkIfCharIsNumber(char c){
        if(c<zero || c>nine){
            throw new IllegalArgumentException(ErrorResource.errorStart+ ErrorResource.charIsNotNumber);
        }
    }

    public void validate(List<Integer> numbers){
        if(numbers.size() != Resource.numberSize){
            throw new IllegalArgumentException(ErrorResource.errorStart+ ErrorResource.numberCountNotFit);
        }
    }

    public void setBonusNumber(int bonusNumber) {
        if(this.numbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorResource.errorStart+bonusNumberAlreadyIn);
        }
        this.bonusNumber = bonusNumber;
    }
}
