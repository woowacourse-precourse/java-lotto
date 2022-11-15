package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Amount;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

import java.util.NoSuchElementException;

import static lotto.utils.StringParser.parseInputToIntegerList;

public final class Input {
    private static final String INVALID_PARSE_STRING_TO_INTEGER_MESSAGE = "[ERROR] 로또 번호는 숫자를 입력해야 합니다.";
    private Input() {
    }

    public static Amount inputAmount() {
        String input = Console.readLine();
        validateParseStringToInteger(input);
        return new Amount(Integer.parseInt(input));
    }

    public static Lotto inputWinningNumbers() {
        String input = Console.readLine();
        return new Lotto(parseInputToIntegerList(input));
    }

    public static Bonus inputBonusNumber() {
        String input = Console.readLine();
        validateParseStringToInteger(input);
        return new Bonus(Integer.parseInt(input));
    }

    private static void validateParseStringToInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_PARSE_STRING_TO_INTEGER_MESSAGE);
            throw new NoSuchElementException(INVALID_PARSE_STRING_TO_INTEGER_MESSAGE);
        }
    }
}
