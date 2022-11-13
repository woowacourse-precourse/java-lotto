package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Amount;

import java.util.NoSuchElementException;

public final class Input {
    private Input() {}

    public static Amount inputAmount() {
        String input = Console.readLine();
        validateParseStringToInteger(input);
        return new Amount(Integer.parseInt(input));
    }

    private static void validateParseStringToInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 번호는 숫자만 입력해야 합니다.");
            throw new NoSuchElementException();
        }
    }
}
