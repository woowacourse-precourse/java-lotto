package lotto.model;

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
        if (numbers.size() != 6) throw new IllegalArgumentException("로또 번호 6개를 입력해주세요.");

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) throw new IllegalArgumentException("로또의 각 번호는 중복이 없어야 합니다.");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int draw(List<Integer> answer, int bonus) {
        return 0;
    }


    @Override
    public String toString() {
        return numbers.toString();
    }

}