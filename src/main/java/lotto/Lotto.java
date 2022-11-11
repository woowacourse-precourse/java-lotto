package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isSize_6(numbers);
        isNotDuplicated(numbers);
    }
    private void isSize_6(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 여야 합니다.");
        }
    }
    private void isNotDuplicated(List<Integer> numbers){
        int notDuplicatedSize = (int) numbers.stream().distinct().count();
    }

    // TODO: 추가 기능 구현
}
