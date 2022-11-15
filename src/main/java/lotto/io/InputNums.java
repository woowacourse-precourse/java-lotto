package lotto.io;

import static lotto.message.ErrorMessage.INVALID_LOTTO_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputNums {
    private String input;
    private String delim;

    public InputNums(String delim, String input) {
        this.delim = delim;
        this.input = input;
    }

    public List<Integer> splitToInts() {
        try {
            return integers();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    private List<Integer> integers() {
        return intStreamFor().collect(
                Collectors.toList());
    }

    private Stream<Integer> intStreamFor() {
        return Arrays.stream(input.split(delim)).map(String::trim).map(Integer::parseInt);
    }
}
