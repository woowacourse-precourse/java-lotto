package lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.collectionPrintout.*;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public void addBonusNumber(int number){
        validate(number);
        numbers.add(number);
    }
    public int compareWithRandomNumbers(List<Integer> randomNumbers){
        int sucess=0;
        for(int i=0;i<numbers.size()-1;i++){
            if(randomNumbers.contains(numbers.get(i)))sucess++;
        }
        if(sucess==6)return 1;
        if(sucess==5&&randomNumbers.contains(numbers.get(6)))return 2;
        if(sucess==5)return 3;
        if(sucess==4)return 4;
        if(sucess==3)return 5;
        return 0;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(exceptionHeader+wrongNumberSize);
        }

        HashSet<Integer> setNumbers=new HashSet<>(numbers);
        if(setNumbers.size()!=6){
            throw new IllegalArgumentException(exceptionHeader+duplicateNumbers);
        }
    }
    private void validate(int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(exceptionHeader + duplicateNumbers);
        }
    }


    public void printNumbers() {
       System.out.print(this.numbers);
    }

    // TODO: 추가 기능 구현
}
