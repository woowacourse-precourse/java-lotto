package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputConsole {

    public static final String PURCHASE_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int purchaseMoney() {
        System.out.println(PURCHASE_MONEY_INPUT_MESSAGE);
        int money = Integer.parseInt(Console.readLine());
        return money;
    }

    public static List<Integer> winningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        String numbers = Console.readLine();
        List<Integer> winningNumbers = splitNumber(numbers);
        return winningNumbers;
    }

    private static List<Integer> splitNumber(String numbers) {
        int[] splitNumbers = Stream.of(numbers.split(",")).mapToInt(Integer::parseInt).toArray();
        List<Integer> winningNumbers = Arrays.stream(splitNumbers).boxed().collect(Collectors.toList());
        return winningNumbers;
    }

    public static int bonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
