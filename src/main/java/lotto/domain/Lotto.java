package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public boolean hasPlace(int index, int number) {
        return numbers.get(index) == number;
    }

    public int getMatchingNumber(List<Integer> computer) {
        return (int) IntStream.range(0, computer.size())
                .filter(index -> hasPlace(index, computer.get(index))).count();
    }

    public List<Integer> getSortedNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();

        message.append("[");
        for (int number : getSortedNumbers()) {
            message.append(number);

            if (number != numbers.get(numbers.size() - 1)) {
                message.append(", ");
            }
        }
        message.append("]");

        return message.toString();
    }

}
