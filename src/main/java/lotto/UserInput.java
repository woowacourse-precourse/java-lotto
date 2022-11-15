package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Validator.validateNumber;
import static lotto.Validator.validatePurchaseMoney;

public class UserInput {
    public static Long getPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        validatePurchaseMoney(input);

        return Long.parseLong(input);
    }

    public static WinningNumbers getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = convertToList(input);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input2 = Console.readLine();
        Integer bonus = convertToBonus(input2);

        return new WinningNumbers(numbers, bonus);
    }

    private static List<Integer> convertToList(String input) {
        return Arrays.stream(input.split(","))
                .filter(Validator::validateNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static Integer convertToBonus(String input) {
        validateNumber(input);
        return Integer.parseInt(input);
    }
}
