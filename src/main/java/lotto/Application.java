package lotto;

import config.ErrorConstants;
import ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            int payment = UserInterface.readPayment();
            List<Lotto> boughtLotteries = buyLotteries(payment / 1000);
            UserInterface.printBoughtLotteries(boughtLotteries);

            LottoRound lottoRound = makeLottoRound();
            LottoStatistics statistics = makeStatistics(boughtLotteries, lottoRound);

            UserInterface.printStatistics(statistics);
        } catch (IllegalArgumentException e) {
            UserInterface.printError(e);
        }
    }

    private static List<Lotto> buyLotteries(int num) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lotteries.add(Lotto.createRandomLotto());
        }
        return lotteries;
    }

    private static LottoRound makeLottoRound() throws IllegalArgumentException {
        Lotto luckyNumbers = UserInterface.readLuckyNumbers();
        int bonusNumber = UserInterface.readBonusNumber();
        return new LottoRound(luckyNumbers, bonusNumber);
    }

    private static LottoStatistics makeStatistics(List<Lotto> boughtLotteries, LottoRound lottoRound) throws IllegalArgumentException {
        LottoStatistics statistics = new LottoStatistics();
        for (Lotto lotto : boughtLotteries) {
            statistics.add(lottoRound.getRank(lotto));
        }
        return statistics;
    }
}
