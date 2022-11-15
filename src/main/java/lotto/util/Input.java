package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

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
     * 입력한 문자열이 숫자로만 이루어진 것인지 확인하는 메소드
     */
    private static boolean isNumeric(String number) {
        return number.chars().allMatch(Character::isDigit);
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

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        String number = Console.readLine();

        if (!isValidBonusNumber(number, winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 보너스 번호입니다.");
        }

        return Integer.parseInt(number);
    }

    private static boolean isValidBonusNumber(String number, List<Integer> winningNumbers) {
        return isNumeric(number) && isValidRange(number) && !duplicatedWithWinningNumber(number, winningNumbers);
    }

    /**
     * 숫자의 범위가 1~ 45 인지 확인하는 메소드
     */
    private static boolean isValidRange(String number) {
        return Integer.parseInt(number) >= START_NUMBER && Integer.parseInt(number) <= END_NUMBER;
    }

    /**
     * 보너스 번호가 당첨 번호와 중복되는지 확인하는 메소드
     */
    private static boolean duplicatedWithWinningNumber(String number, List<Integer> winningNumbers) {
        return winningNumbers.contains(Integer.parseInt(number));
    }
}
