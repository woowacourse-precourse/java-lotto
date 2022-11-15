package lotto;

import java.util.List;

public abstract class AbstractLottoMachine {
    public final void run() {
        try {
            long amount = parseAmount(askAmountWithUser());
            List<Lotto> lotteries = buyLotteries(amount);
            displayLotteries(lotteries);
            StringBuilder primaryNumbers = askPrimaryNumbersWithUser();
            String winningNumbers = askBonusNumberWithUser(primaryNumbers);
            Statistic statistic = generateStatistic(winningNumbers, lotteries, amount);
            displayStatistic(statistic);
        } catch (Throwable e) {
            // Rollback
        }
    }

    private long parseAmount(String amount) {
        try {
            return Long.parseLong(amount);
        } catch (NumberFormatException e) {
            Logger.error("올바른 값을 입력하세요: ^" + amount + "$");
            throw new IllegalArgumentException();
        }
    }

    protected abstract String askAmountWithUser();

    protected abstract List<Lotto> buyLotteries(long amount);

    protected abstract void displayLotteries(List<Lotto> lotteries);

    protected abstract StringBuilder askPrimaryNumbersWithUser();

    protected abstract String askBonusNumberWithUser(StringBuilder sb);

    protected abstract Statistic generateStatistic(String winningNumbers, List<Lotto> lotteries, long amount);

    protected abstract void displayStatistic(Statistic statistic);
}
