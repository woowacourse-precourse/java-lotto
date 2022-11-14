package lotto;

import view.UserInterface;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int payment = UserInterface.readPayment();
            List<Lotto> boughtLotteries = buyLotteries(payment / 1000);
            UserInterface.printBoughtLotteries(boughtLotteries);

            LottoCheck lottoRound = makeLottoRound();
            LottoResult statistics = makeStatistics(boughtLotteries, lottoRound);

            UserInterface.printStatistics(statistics);
        } catch (IllegalArgumentException e) {
            UserInterface.printError(e);
        }
    }
}