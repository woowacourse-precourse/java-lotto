package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개 입니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하 범위의 숫자이어야 합니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> deduplicatedNumbers = new HashSet<>(numbers);
        if (deduplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    public String showNumbers() {
        List<Integer> lottoNumbers = new ArrayList<Integer>(this.numbers);
        Collections.sort(lottoNumbers);
        String message = "[";
        for (int number : lottoNumbers) {
            message += number + ", ";
        }
        message = message.substring(0, message.length() - 2);
        message += "]";
        return message;
    }

    public int containNumber(int number) {
        if (numbers.contains(number)) {
            return 1;
        }
        return 0;
    }
}
