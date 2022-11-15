package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Consumer consumer = new Consumer();
            consumer.buyLotto();
            Lotto winLotto = consumer.putWinLotto();
            int bonusNumber = consumer.putBonusNumber();
            List<Integer> resultArray = consumer.calcStat(winLotto, bonusNumber);
            resultArray = consumer.calcProfit(resultArray);
            LottoConsoleIo.printResultStatistics(resultArray);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
