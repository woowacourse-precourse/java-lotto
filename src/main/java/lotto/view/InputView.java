package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static final String SEPARATOR = ",";

    public static int insertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        validateMoney(money);

        return Integer.parseInt(money);
    }

    private static void validateMoney(String money) {
        if (containsNonNumeric(money)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAINS_NON_NUMERIC_VALUES);
        }
    }

    private static boolean containsNonNumeric(String money) {
        return !money.chars().allMatch(Character::isDigit);
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbersWithSeparator = Console.readLine();

        return getWinningNumbers(numbersWithSeparator);
    }

    public static int inputBounsNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        return Integer.parseInt(bonusNumber);
    }

    private static List<Integer> getWinningNumbers(String numbersWithSeparator) {
        String[] winningNumbers = numbersWithSeparator.split(SEPARATOR);
        return Arrays.stream(winningNumbers)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }
}
