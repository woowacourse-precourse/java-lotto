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

    public int getMatchingNumber(List<Integer> player) {
        return (int) IntStream.range(0, player.size())
                .filter(index -> hasPlace(index, player.get(index))).count();
    }

    public List<Integer> getSortedNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = getSortedNumbers();
        StringBuilder message = new StringBuilder();

        message.append("[");
        for (int number : sortedNumbers) {
            message.append(number);

            if (number != sortedNumbers.get(sortedNumbers.size() - 1)) {
                message.append(", ");
            }
        }
        message.append("]");

        return message.toString();
    }

}
