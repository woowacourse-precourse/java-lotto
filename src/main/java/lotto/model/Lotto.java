package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers = new ArrayList<>();
    private final int MAX = 45;
    private final int MIN = 1;

    public Lotto(List<Integer> nums) {
        validate(nums);
        this.numbers.addAll(nums);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);
        overlapValidate(numbers);
        rangeValidate(numbers);
    }

    private void rangeValidate(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (num < MIN || num > MAX) {
                throw new IllegalArgumentException("[ERROR] 번호가 잘못된 번호입니다.");
            }
        }
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 길이가 6이 아닙니다.");
        }
    }

    private void overlapValidate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
