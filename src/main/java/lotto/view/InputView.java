package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Optional;

public class InputView {

    private static final String ERROR_FOR_NULL_INPUT = "[ERROR] null 값이 입력되었습니다.";
    private static final String ERROR_FOR_NOT_INTEGER_INPUT = "[ERROR] 정수가 아닌 값이 입력되었습니다.";

    public int readInt () {
        String input = Optional.ofNullable(Console.readLine())
                .orElseThrow(() -> new IllegalArgumentException(ERROR_FOR_NULL_INPUT));

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_FOR_NOT_INTEGER_INPUT);
        }
    }
}
