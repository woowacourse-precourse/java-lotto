package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class LottoScanner {

    private static final String NOT_ONLY_NUMBER = "숫자만 입력해 주세요.";

    public String number() {
        String number = readLine();
        validateItContainsOnlyNumber(number);

        return number;
    }

    public String formattedNumber() {
        return readLine();
    }

    private String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    void validateItContainsOnlyNumber(String money) {
        final String REGEX_FOR_NUMBER = "^\\d+$";
        if (!money.matches(REGEX_FOR_NUMBER)) {
            throw new IllegalArgumentException(NOT_ONLY_NUMBER);
        }
    }
}
