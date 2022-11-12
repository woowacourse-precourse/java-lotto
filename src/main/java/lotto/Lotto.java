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
        if(numbers.size()!=numbers.stream().distinct().count())
            throw new IllegalArgumentException();
    }

    private void numSort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public void printNumbers() {
        System.out.println(numbers);
    }

    public int getNum(int index) {
        return numbers.get(index);
    }

    public List<Integer> getNums() {
        return numbers;
    }
}
