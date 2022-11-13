package lotto.domain;

import lotto.validation.Validator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateSize(numbers, 6);
        Validator.validateNonDuplicatedList(numbers);
        Validator.validateNumbersRange(numbers, 1,45);
    }

    public String getNumbersString(){
        Collections.sort(numbers);
        return numbers.toString();
    }

    public void validateNonDuplicatedNumber(int number){
        if(numbers.contains(number)){
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 기존 당첨 번호와 중복됩니다.");
        }
    }

}
