package lotto;

import lotto.boundary.Console;
import lotto.boundary.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoMachine extends AbstractLottoMachine {
    private static final long BUY_UNIT = 1_000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUM_DRAW = 6;

    @Override
    protected String askAmountWithUser() {
        System.out.println("구매금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    protected List<Lotto> buyLotteries(long amount) {
        if (0 != amount % BUY_UNIT) {
            Logger.error("올바른 단위를 입력하세요: ^" + amount + "$");
            throw new IllegalArgumentException();
        }
        return LongStream.range(0L, amount / BUY_UNIT)
                .mapToObj(n -> Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUM_DRAW))
                .map(Lotto::new)
                .collect(Collectors.toList());
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
