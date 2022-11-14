package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.errorMessage.ErrorMessage;

public class UserInput {

    private static final String INPUT_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNINGNUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BOUNSNUMBER = "보너스 번호를 입력해 주세요.";
    private static final int FIRST_INDEX = 0;
    private static final String DELIMITER = ",";

    public static int InputMoney() {
        System.out.println(INPUT_PAYMENT);
        String input = Console.readLine();
        validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> InputWinningNums() {
        System.out.println(INPUT_WINNINGNUMBER);
        String input = Console.readLine();
        validateContainsDelimiter(input);
        String[] winningnums = input.split(DELIMITER);
        validateIsAllNumeric(winningnums);
        return Arrays.stream(winningnums)
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    public static int InputBonusNum() {
        System.out.println(INPUT_BOUNSNUMBER);
        String input = Console.readLine();
        validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    private static void validateIsNumeric(String input) {
        if (haveNonNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.ALLOW_ONLY_NUMERIC);
        }
    }

    private static boolean haveNonNumeric(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    private static void validateIsAllNumeric(String[] input) {
        for (String number : input) {
            if (isNonNumeric(number)) {
                throw new IllegalArgumentException(ErrorMessage.ALLOW_ONLY_NUMERIC);
            }
        }
    }

    private static boolean isNonNumeric(String number) {
        return !Character.isDigit(number.charAt(FIRST_INDEX));
    }

    private static void validateContainsDelimiter(String input) {
        if (notContainFixedDelimiter(input)) {
            throw new IllegalArgumentException(ErrorMessage.ALLOW_ONLY_FIXED_DELIMITER);
        }
    }

    private static boolean notContainFixedDelimiter(String input) {
        return !input.contains(DELIMITER);
    }
}
