package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            // 로또 구매
            Store store = new Store();
            User user = new User(enterMoney());
            user.buyLottoAll(store);
            user.printLotto();

            // 당첨 번호
            Host host = new Host(new Lotto(enterWinningNumbers()),
                    enterWinningBonusNumber());

            // 당첨 통계
            List<Winning> drawResults = host.drawLotto(user);
            Statistics statistics = new Statistics();
            statistics.generateStatistics(drawResults);
            statistics.printStatistics();

        } catch (IllegalArgumentException e) {
            System.out.println(Constants.ERROR_PREFIX + e.getMessage());
        }
    }

    private static int enterMoney() {
        System.out.println(Constants.CONSOLE_MONEY);

        int money = Integer.parseInt(Console.readLine());
        if (money % Constants.MONEY_TERMS != 0) {
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
        Collections.sort(numbers);
        return numbers;
    }

    private static int enterWinningBonusNumber() {
        System.out.println(Constants.CONSOLE_LOTTO_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
}
