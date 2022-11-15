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
        if (validateIsDuplicate(numbers))
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.");
    }

    public boolean validateIsDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count())
            return true;
        return false;
    }

    public List<Integer> getLottoNumber () {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            nums.add(numbers.get(i));
        }
        return nums;
    }
}
