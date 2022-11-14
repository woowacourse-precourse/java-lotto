package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호는 중복이 없어야 합니다");
        }
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 숫자만 입력 가능합니다");
            }
        }
    }
    public List<Integer> getNumbers(){
        return numbers;
    }

}
