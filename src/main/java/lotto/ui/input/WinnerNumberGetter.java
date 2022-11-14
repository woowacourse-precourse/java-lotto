package lotto.ui.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntConsumer;

public class WinnerNumberGetter {
    private static final IllegalArgumentException ILLEGAL_ARGUMENT_EXCEPTION = new IllegalArgumentException("[ERROR] 쉼표로 구분되는 6자리의 숫자를 입력해주세요");
    private static final String WINNING_NUMBER_REQUEST = "당첨 번호를 입력해주세요.";
    private static final String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해주세요.";

    public static Map<Integer, Integer> getLotteryWinningNumbersInput() throws IllegalArgumentException{
        System.out.println(WINNING_NUMBER_REQUEST);
        Map<Integer, Integer> numbers = new HashMap<>();
        try {
            Arrays.asList(Console.readLine().split(",")).stream()
                    .map(String::trim)
                    .mapToInt(Integer::parseInt).iterator().forEachRemaining((IntConsumer) i -> numbers.put(i, 1));
            if (numbers.size() != 6) {
                throw ILLEGAL_ARGUMENT_EXCEPTION;
            }
        } catch (NumberFormatException ne) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
        return numbers;
    }

    public static int getBonusInput() {
        System.out.println(BONUS_NUMBER_REQUEST);
        int bonus = Integer.parseInt(Console.readLine());

        return bonus;
    }
}
