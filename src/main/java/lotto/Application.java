package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money;
        List<Lotto> lotteries = new ArrayList<>();
        List<Integer> winningNumbers = new ArrayList<>();

        try {
            Output.giveMeMoney();
            money = Input.receiveMoney();
            System.out.println();

            for (int i = 0; i < Store.countLines(money); i++) {
                Lotto lottery = new Lotto(Store.makeNumbers());
                lotteries.add(lottery);
            }

            Output.lottoQuantity(money);
            Output.lotteriesNumbers(lotteries);
            System.out.println();

            Output.giveMeWinningNumbers();
            Input.receiveWinningNumbers(winningNumbers);
            System.out.println();

            Output.giveMeBonusNumber();
            Input.receiveBonusNumber(winningNumbers);
            System.out.println();

            Judge judge = new Judge();
            judge.setRankCount(lotteries, winningNumbers);

            Output.winningHistory(judge);
            Output.earningRate(judge, money);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
