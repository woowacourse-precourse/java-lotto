package lotto.domain;

import lotto.service.NumberChart;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        verifyNumberOverlap(numbers);
        verifySixNumber(numbers);
        verifyBetween1and45(numbers);
    }

    private void verifyNumberOverlap(List<Integer> numbers) {
        if (!(numbers.size() == numbers.stream().distinct().count())) {
            throw new IllegalArgumentException(" 중복인 숫자가 있습니다.");
        }
    }

    private void verifySixNumber(List<Integer> numbers) {
        if (!(numbers.size() == NumberChart.LOTTO_SIZE.getValue())) {
            throw new IllegalArgumentException(" 6개의 숫자를 입력하세여");
        }
    }

    private void verifyBetween1and45(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(NumberChart.MIN_NUMBER.getValue() <= number && number <= NumberChart.MAX_NUMBER.getValue())) {
                throw new IllegalArgumentException(" 1 ~ 45 사이의 숫자만 입력해 주세요");
            }
        }
    }

    public List<Integer> value() {
        return new ArrayList<>(numbers);
    }


}
