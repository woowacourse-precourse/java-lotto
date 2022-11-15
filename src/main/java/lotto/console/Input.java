package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Input {

    public static int enterMoney() {
        System.out.println(Constants.CONSOLE_MONEY);
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);
        return money;
    }

    public static void validateMoney(int money) {
        if (money % Constants.MONEY_TERMS != 0) {
            throw new IllegalArgumentException(Constants.LOTTO_MONEY_EXCEPTION);
        }
        if (money <= 0) {
            throw new IllegalArgumentException(Constants.LOTTO_MONEY_EXCEPTION);
        }
    }

    public static List<Integer> enterWinningNumbers() {
        System.out.println(Constants.CONSOLE_LOTTO_NUMBER);

        String input = Console.readLine();

        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(",")) {
            numbers.add(Integer.parseInt(number));
        }
        Collections.sort(numbers);
        return numbers;
    }

    public static int enterWinningBonusNumber() {
        System.out.println(Constants.CONSOLE_LOTTO_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
}
