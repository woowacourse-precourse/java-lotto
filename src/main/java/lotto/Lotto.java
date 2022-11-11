package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    public List<Integer> getWinningNumbers() {
        return numbers;
    }

    public void validateLength(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입니다.");
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        List<Integer> DuplicationValidator = new ArrayList<>();

        for(int number : numbers) {
            if(DuplicationValidator.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
            }

            DuplicationValidator.add(number);
        }
    }
}
