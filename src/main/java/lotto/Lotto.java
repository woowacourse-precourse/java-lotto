package lotto;

import lotto.CheckInputException;

import lotto.Util;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException{
        validate(numbers);
        try {
            CheckInputException.checkDuplicateNumbers(numbers);
        } catch(IllegalArgumentException iae){
            throw iae;
        }
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getLottoInfo(){
        return numbers;
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.toString();
    }


}
