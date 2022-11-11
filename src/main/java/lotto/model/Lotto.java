package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> nums) {
        validate(nums);
        Collections.sort(nums);
        this.numbers = nums;

    }

    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);
        overlapValidate(numbers);
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
