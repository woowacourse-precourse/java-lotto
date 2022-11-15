package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.exception.LottoException.FORBID_EMPTY;
import static lotto.exception.LottoException.NOT_NUMBER;

public class Reader {

    public List<Integer> readNumbers() {
        String input = Console.readLine();
        List<String> numbers = Arrays.asList(input.split(","));
        numbers.forEach(this::isNumeric);
        return numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public Long readLongNumber() {
        String input = Console.readLine();
        isNumeric(input);
        return Long.parseLong(input);
    }

    public void isNumeric(String input) {
        if (input == null) {
            throw new IllegalArgumentException(FORBID_EMPTY.getErrorMessage());
        }
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getErrorMessage());
        }
    }
}
