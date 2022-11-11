package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            int money = enterMoney();

            Winning winningLotto = new Winning(new Lotto(enterWinningNumbers()),
                    enterWinningBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(Constants.ERROR_PREFIX + e.getMessage());
        }
    }

    private static int enterMoney() {
        System.out.println(Constants.CONSOLE_MONEY);

        int money = Integer.parseInt(Console.readLine());
        if (money % Constants.LOTTO_PRICE_TERMS != 0) {
            throw new IllegalArgumentException(Constants.LOTTO_MONEY_EXCEPTION);
        }

        return money;
    }

    private static List<Integer> enterWinningNumbers() {
        System.out.println(Constants.CONSOLE_LOTTO_NUMBER);

        String input = Console.readLine();

        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(",")) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private static int enterWinningBonusNumber() {
        System.out.println(Constants.CONSOLE_LOTTO_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
}
