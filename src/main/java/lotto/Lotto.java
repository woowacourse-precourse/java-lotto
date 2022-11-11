package lotto;

import java.util.List;

import validate.Check;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numberSize(numbers);
        this.numbers = numbers;
    }

    public static void numberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printNumber() {
        for (Integer data : numbers) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }


}
