package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {

    public static int InputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> InputWinningNums() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateContainsDelimiter(input);
        String[] winningnums = input.split(",");
        validateIsAllNumeric(winningnums);
        return Arrays.stream(winningnums)
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    public static int InputBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    private static void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다");
        }
    }

    private static void validateIsAllNumeric(String[] input) {
        for (String number : input) {
            if (!Character.isDigit(number.charAt(0))) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다");
            }
        }
    }

    private static void validateContainsDelimiter(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 지정된 구분자가 포함되지 않았습니다");
        }
    }
}
