package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers; // 사용자가 생성하는 숫자들

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

    public static List<Integer> CorrectLottoNumber() {
        List<Integer> correctNumber = CorrectNumberGenerator.createCorrectNumber();
        new Lotto(correctNumber);

        return correctNumber;
    }



}
