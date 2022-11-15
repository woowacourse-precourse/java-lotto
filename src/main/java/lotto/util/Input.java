package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final int COMMA_COUNT = 5;
    private static final int LOTTO_COUNT = 6;
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
            throw new IllegalArgumentException("[ERROR] 구입 금액이 너무 크거나 입력이 잘못되었습니다.");
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

        if (!isValidWinningNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 당첨 번호입니다.");
        }

        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static boolean isValidWinningNumbers(String numbers) {
        return isSeparatedByComma(numbers) && isNumerics(numbers) && isValidCount(numbers) && isValidRanges(numbers);
    }

    /**
     * 쉼표 5개로 구분되어 있는 숫자들의 입력인지 확인하는 메소드
     */
    private static boolean isSeparatedByComma(String numbers) {
        return numbers.chars()
                .filter(character -> character == ',')
                .count() == COMMA_COUNT;
    }

    /**
     * 쉼표로 분리한 입력들이 숫자인지 확인하는 메소드
     */
    private static boolean isNumerics(String numbers) {
        return Arrays.stream(numbers.split(","))
                .allMatch(Input::isNumeric);
    }

    /**
     * 분리한 숫자들의 개수가 6개인지 확인하는 메소드
     */
    private static boolean isValidCount(String numbers) {
        return numbers.split(",").length == LOTTO_COUNT;
    }

    /**
     * 분리한 숫자들의 범위가 1~45 인지 확인하는 메소드
     */
    private static boolean isValidRanges(String numbers) {
        return Arrays.stream(numbers.split(","))
                .allMatch(Input::isValidRange);
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
