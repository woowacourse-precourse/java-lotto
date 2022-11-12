package lotto;

import java.util.List;
import java.util.ArrayList;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자만 입력 가능합니다.");
        }
    }

    public List<Integer> getLottoNumber () {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            nums.add(numbers.get(i));
        }
        return nums;
    }
}
