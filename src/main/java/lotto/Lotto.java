package lotto;

import java.util.HashSet;
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
            throw new IllegalArgumentException("[ERROR] 총 6개의 로또 번호를 뽑아야 합니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException
                    ("[ERROR] 로또 번호는 1~45 범위 안에 있는 정수값이어야 합니다.");
            }
        }
        Set<Integer> numberSet=new HashSet<>(numbers);
        if (numberSet.size()!=6){
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 로또 번호를 뽑아야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
