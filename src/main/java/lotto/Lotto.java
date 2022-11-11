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
        isInRange(numbers);
    }
    private void isSize_6(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 여야 합니다.");
        }
    }
    private void isNotDuplicated(List<Integer> numbers){
        int notDuplicatedSize = (int) numbers.stream().distinct().count();
        if(notDuplicatedSize != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }
    private void isInRange(List<Integer> numbers){
        for(int n : numbers){
            if(n<1 || n>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
