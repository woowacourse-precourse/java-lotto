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

            LottoCheck lottoCheck = makeLottoRound();
            LottoResult statistics = makeStatistics(boughtLotteries, lottoCheck);

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

    private static LottoCheck makeLottoRound() throws IllegalArgumentException {
        Lotto luckyNumbers = UserInterface.readLuckyNumbers();
        int bonusNumber = UserInterface.readBonusNumber();
        return new LottoCheck(luckyNumbers, bonusNumber);
    }

    private static LottoResult makeStatistics(List<Lotto> boughtLotteries, LottoCheck lottoCheck) {
        LottoResult statistics = new LottoResult();
        for (Lotto lotto : boughtLotteries) {
            statistics.add(lottoCheck.getRank(lotto));
        }
        return statistics;
    }
}