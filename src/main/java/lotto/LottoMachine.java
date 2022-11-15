package lotto;

import lotto.boundary.Console;

import java.util.List;

public class LottoMachine extends AbstractLottoMachine {
    @Override
    protected String askAmountWithUser() {
        System.out.println("구매금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    protected List<Lotto> buyLotteries(long amount) {
        return null;
    }

    @Override
    protected void displayLotteries(List<Lotto> lotteries) {

    }

    @Override
    protected StringBuilder askPrimaryNumbersWithUser() {
        return null;
    }

    @Override
    protected String askBonusNumberWithUser(StringBuilder sb) {
        return null;
    }

    @Override
    protected Statistic generateStatistic(String winningNumbers, List<Lotto> lotteries, long amount) {
        return null;
    }

    @Override
    protected void displayStatistic(Statistic statistic) {

    }
}
