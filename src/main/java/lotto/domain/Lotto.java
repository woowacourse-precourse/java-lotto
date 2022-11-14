package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public String showNumbers() {
        Collections.sort(this.numbers);
        String message = "[";
        for (int number : numbers) {
            message += number + ", ";
        }
        message = message.substring(0, message.length() - 2);
        message += "]";
        return message;
    }
}
