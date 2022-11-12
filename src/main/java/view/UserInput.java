package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import util.Validation;

public class UserInput {

    // 구입 금액을 입력하는 기능
    public static int purchaseMoney() {
        String money = Console.readLine();
        Validation.validatePurchaseMoney(money);
        return Integer.parseInt(money);
    }

    // 당첨 번호를 입력하는 기능
    public static List<Integer> winningNumberInput() {
        String winningNumber = Console.readLine();

        List<String> winningNumberSplit = Arrays.stream(winningNumber.split(","))
            .collect(Collectors.toList());

        return winningNumberSplit.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    // 문자열을 ,를 기준으로 분리하는 기능
    private static List<String> splitString(String input) {
        return Arrays.stream(input.split(","))
            .collect(Collectors.toList());
    }

}
