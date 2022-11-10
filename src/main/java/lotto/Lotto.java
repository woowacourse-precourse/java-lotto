package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numSort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void numSort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public void printNumbers() {
        for (int i = 0; i < numbers.size(); i++)
            System.out.print(" " + numbers.get(i));
        System.out.println("");
    }


    // TODO: 추가 기능 구현
}
