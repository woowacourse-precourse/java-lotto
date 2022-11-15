package lotto.ui.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.ConstValue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntConsumer;

public class WinnerNumberGetter {
    private static final String WINNING_NUMBER_REQUEST = "당첨 번호를 입력해주세요.";
    private static final String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해주세요.";

    public static Map<Integer, Integer> getLotteryWinningNumbersInput() throws IllegalArgumentException{
        System.out.println(WINNING_NUMBER_REQUEST);
        try {
            Map<Integer, Integer> numbers = new HashMap<>();
            Arrays.asList(Console.readLine().split(",")).stream()
                    .map(String::trim)
                            .mapToInt(Integer::parseInt).iterator().forEachRemaining((IntConsumer) i -> numbers.put(i, 1));
            if (numbers.size() != ConstValue.Numbers.LOTTO_LENGTH || !checkNumberRange(numbers)) {
                throw new IllegalArgumentException(ConstValue.ErrorMessages.ILLEGAL_ARGUMENT_EXCEPTION_FOR_WINNING_NUMBER);
            }
            return numbers;
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(ConstValue.ErrorMessages.ILLEGAL_ARGUMENT_EXCEPTION_FOR_WINNING_NUMBER);
        }
    }

    public static int getBonusInput() {
        try {
            System.out.println(BONUS_NUMBER_REQUEST);
            int bonus = Integer.parseInt(Console.readLine());
            if (bonus < ConstValue.Numbers.MIN_LOTTO_NUM || bonus > ConstValue.Numbers.MAX_LOTTO_NUM) {
                throw new IllegalArgumentException(ConstValue.ErrorMessages.ILLEGAL_ARGUMENT_EXCEPTION_FOR_BONUS_NUMBER);
            }
            return bonus;
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(ConstValue.ErrorMessages.ILLEGAL_ARGUMENT_EXCEPTION_FOR_BONUS_NUMBER);
        }
    }

    private static boolean checkNumberRange(Map<Integer, Integer> numbers) {
        for (Integer number : numbers.keySet()) {
            if (number < ConstValue.Numbers.MIN_LOTTO_NUM || number > ConstValue.Numbers.MAX_LOTTO_NUM)
                return false;
        }
        return true;
    }
}
