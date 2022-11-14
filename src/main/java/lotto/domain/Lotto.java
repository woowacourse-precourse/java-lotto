package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_START_NUMBER = 1; // 로또 시작 번호
    public static final int LOTTO_END_NUMBER = 45; // 로또 끝 번호
    public static final int LOTTO_SIZE = 6; // 로또 한세트의 번호수
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.toString();
    }
}