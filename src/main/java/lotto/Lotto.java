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
