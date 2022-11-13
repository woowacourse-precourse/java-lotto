package lotto.io;

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
            throw new IllegalArgumentException("[ERROR] 입력한 수가 정수 형식이 아닙니다.");
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
