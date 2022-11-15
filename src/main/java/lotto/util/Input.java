package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    /**
     * 구입 금액을 입력받는 메소드
     */
    public static int inputAmount() {
        try {
            String amount = Console.readLine();
            return Integer.parseInt(amount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 너무 크거나 입력이 올바르지 않습니다.");
        }
    }

    /**
     * 당첨 번호를 입력받는 메소드
     */
    public static List<Integer> inputWinningNumbers() {
        String numbers = Console.readLine();

        validateWinningNumbers(numbers);

        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    /**
     * 보너스 번호를 입력받는 메소드
     */
    public static int inputBonusNumber() {
        try {
            String bonus = Console.readLine();
            return Integer.parseInt(bonus);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 입력이 올바르지 않습니다.");
        }
    }

    /**
     * 당첨 번호의 입력 형식에 대한 예외 처리를 하는 메소드
     */
    private static void validateWinningNumbers(String numbers) {
        if (!isSeparatedByCommaAndNumerics(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 입력이 올바르지 않습니다.");
        }
    }

    /**
     * 쉼표 5개로 구분되어 있는 숫자들의 입력인지 확인하는 메소드
     */
    private static boolean isSeparatedByCommaAndNumerics(String numbers) {
        return numbers.matches("(\\d)+,(\\d)+,(\\d)+,(\\d)+,(\\d)+,(\\d)+");
    }
}
