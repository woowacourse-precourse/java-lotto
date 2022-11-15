package lotto.domain;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (Integer num: numbers) {
            if (num > 45 || num < 1) {
                System.out.println(Message.LOTTO_NUM_RANGE_ERROR.get());
                throw new IllegalArgumentException();
            }
            if (numbers.indexOf(num) != numbers.lastIndexOf(num)) {
                System.out.println(Message.LOTTO_NUM_DUPLICATE_ERROR.get());
                throw new IllegalArgumentException();
            }
        }
    }
    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return numbers;
    }
}
