package lotto;

import java.util.List;
import lotto.global.Message;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || numbers.size() != numbers.stream().distinct().count()) {
            lottoError();
        }
        numbers.forEach(number -> {
            if (number < 1 || number > 45) {
                lottoError();
            }
        });
    }

    // TODO: 추가 기능 구현
    private void lottoError() {
        Message.ERROR_LOTTO.print();
        throw new IllegalArgumentException();
    }

    public void print() {
        System.out.printf("[%d, %d, %d, %d, %d, %d]\n", numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(5),
                numbers.get(4), numbers.get(5));
    }
}
