package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        range(numbers);
        this.numbers = numbers;
    }
    public Lotto(List<Integer> numbers, int bonus) {
        numbers = new ArrayList<>(numbers);
        validate(numbers);
        numbers.add(bonus);
        duplicate(numbers);
        range(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    //로또번호 중복 검사
    private void duplicate(List<Integer> numbers){
        boolean[] check = new boolean[45];
        for (int num : numbers) {
            if (!check[num])
                check[num] = true;
            else
                throw new IllegalArgumentException();
        }
    }

    //로또번호 범위 검사
    private void range(List<Integer> numbers){
        for (int num : numbers) {
            if (num < 1 || num > 45)
                throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
