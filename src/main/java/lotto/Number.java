package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Number {

    private List<Integer> numbers;
    private int bonusNumber;

    public List<Integer> stringToList(String input) {
        return Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }
}
