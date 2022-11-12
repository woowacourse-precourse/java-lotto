package lotto;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> printNumber() {
        List<Integer> autoTicketNumbers = new ArrayList<>();
        for (Integer data : numbers) {
            autoTicketNumbers.add(data);
        }

        return autoTicketNumbers;
    }

}
