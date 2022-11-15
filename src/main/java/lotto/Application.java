package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void run() {
        int money = Lotto.inputMoney();
        List<Lotto> lottos = Lotto.issueLotto(money);
        Lotto.printStatistics(lottos, Lotto.inputWinningNumbers(), Lotto.inputBonusNumber());
    }
}