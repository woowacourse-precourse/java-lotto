package lotto.domain;

import static lotto.util.NumberValidator.checkDuplicate;
import static lotto.util.NumberValidator.checkSize;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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
        checkSize(numbers);
        checkDuplicate(numbers);
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public int getMatchingNumber(List<Integer> player) {
        return (int) IntStream.range(0, player.size())
                .filter(index -> hasNumber(player.get(index))).count();
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();

        message.append("[");
        for (int number : numbers) {
            message.append(number);

            if (number != numbers.get(numbers.size() - 1)) {
                message.append(", ");
            }
        }
        message.append("]");

        return message.toString();
    }

}
