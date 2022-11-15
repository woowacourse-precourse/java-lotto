package model;

import java.util.Collections;
import java.util.List;

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
    }

    // TODO: 추가 기능 구현
    public void sort() {
        Collections.sort(numbers);
    }

    public void print() {
        System.out.print("[");

        for(int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + ",");
        }

        System.out.println("]");
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }
}
