package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }


    public List<Integer> getNumbers() {
        List<Integer> copyNumbers = new ArrayList<>();
        for (int n : numbers) copyNumbers.add(n);
        return copyNumbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
