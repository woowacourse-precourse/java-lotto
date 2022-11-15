package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InputView {

    private static final String ERROR_FOR_NULL_INPUT = "[ERROR] null 값이 입력되었습니다.";
    private static final String ERROR_FOR_NOT_INTEGER_INPUT = "[ERROR] 정수가 아닌 값이 입력되었습니다.";

    private static final String DELIMITER = ",";

    public String read() {
        return Optional.ofNullable(Console.readLine())
                .orElseThrow(() -> new IllegalArgumentException(ERROR_FOR_NULL_INPUT));
    }

    public int readInt() {
        try {
            return Integer.parseInt(read());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_FOR_NOT_INTEGER_INPUT);
        }
    }

    public List<Integer> readWinningNumbers() {
        String input = read();

        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
