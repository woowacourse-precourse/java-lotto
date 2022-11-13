package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final int LOTTO_PRICE = 1000;
    private static final int COMMA_COUNT = 5;
    private static final int LOTTO_COUNT = 6;

    /**
     * 구입 금액을 입력받는 메소드
     */
    public static int inputPurchaseAmount() {
        String amount = Console.readLine();

        if (!isValidAmount(amount)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 구매 금액 입니다.");
        }

        return Integer.parseInt(amount);
    }

    private static boolean isValidAmount(String number) {
        return isNumeric(number) && isPositive(number) && isDividedBy1000(number);
    }

    /**
     * 입력한 문자열이 숫자로만 이루어진 것인지 확인하는 메소드
     */
    private static boolean isNumeric(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    /**
     * 입력한 문자열이 양수인지 확인하는 메소드
     */
    private static boolean isPositive(String number) {
        return Integer.parseInt(number) > 0;
    }

    /**
     * 입력한 문자열이 1000원으로 나누어 떨어지는지 확인하는 메소드
     */
    private static boolean isDividedBy1000(String number) {
        return Integer.parseInt(number) % LOTTO_PRICE == 0;
    }

    /**
     * 당첨 번호를 입력받는 메소드
     */
    public static List<Integer> inputWinningNumbers() {
        String numbers = Console.readLine();

        if (!isValidWinningNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 당첨 번호 입니다.");
        }

        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static boolean isValidWinningNumbers(String numbers) {
        return isSeparatedByComma(numbers) && isNumerics(numbers) && isValidCount(numbers);
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
     * 분리한 숫자들의 개수가 6개인지 확인하는 메서드
     */
    private static boolean isValidCount(String numbers) {
        return numbers.split(",").length == LOTTO_COUNT;
    }
}
