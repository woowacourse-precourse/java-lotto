package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumber1To45(numbers);
        exceptDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber1To45(List<Integer> lottoNumbers) {
        for (int eachNumber : lottoNumbers) {
            if (eachNumber < 1 || eachNumber > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지의 숫자입니다.");
        }
    }

    private void exceptDuplicatedNumber(List<Integer> lottoNumbers) {
        Set<Integer> existentNumber = new HashSet<>();
        for (int eachNumber : lottoNumbers) {
            if (existentNumber.contains(eachNumber))
                throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
            existentNumber.add(eachNumber);
        }
    }
}
