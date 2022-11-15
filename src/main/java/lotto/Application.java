package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.console.Constants;
import lotto.player.Host;
import lotto.player.Store;
import lotto.player.User;
import lotto.statistics.Statistics;
import lotto.ticket.Lotto;
import lotto.ticket.Winning;

public class Application {

    public static void main(String[] args) {
        try {
            // 로또 구매
            Store store = new Store();
            int moneyToBuy = enterMoney();
            User user = new User(moneyToBuy);
            user.buyLottoAll(store);
            user.printLotto();

            // 당첨 번호
            Host host = new Host(new Lotto(enterWinningNumbers()),
                    enterWinningBonusNumber());

            // 당첨 통계
            List<Winning> drawResults = host.drawLotto(user);
            Statistics statistics = new Statistics(drawResults);
            statistics.printStatistics();
            statistics.printProfit(moneyToBuy);
        } catch (IllegalArgumentException e) {
            System.out.println(Constants.ERROR_PREFIX + e.getMessage());
        }
    }

    private static int enterMoney() {
        System.out.println(Constants.CONSOLE_MONEY);
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);
        return money;
    }

    private static void validateMoney(int money) {
        if (money % Constants.MONEY_TERMS != 0) {
            throw new IllegalArgumentException(Constants.LOTTO_MONEY_EXCEPTION);
        }
        if (money <= 0) {
            throw new IllegalArgumentException(Constants.LOTTO_MONEY_EXCEPTION);
        }
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
