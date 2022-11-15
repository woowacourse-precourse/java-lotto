package lotto;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 입니다.");
        }
    }

    private void DuplicateNumber(List<Integer> numbers) {
        Set<Integer> number = new HashSet<>(numbers);
        if (number.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    public void NumberRange(List<Integer> numbers) {
        int RangeCount = (int) numbers.stream().filter(number -> number < 1 && 45 < number).count();
        if (RangeCount != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    public List<Integer> GetNumbers(){
        return new ArrayList<>(this.numbers);
    }
}

