package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

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
        return Integer.parseInt(number) % 1000 == 0;
    }

    public static List<Integer> inputWinningNumbers() {
        String numbers = Console.readLine();
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
