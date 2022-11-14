package lotto;

import lotto.data.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoComparator;
import lotto.domain.LottoGenerator;
import lotto.domain.RewardCalculator;
import lotto.presentation.LottoPrinter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardCalculatorTest {

    private final int startNumber = 1;
    private final int endNumber = 6;
    private final int numberCount = 6;
    private final int priceUnit = 1000;
    private final int price = 1000;
    private LottoGenerator lottoGenerator;
    private LottoPrinter lottoPrinter;
    private LottoComparator lottoComparator;
    private RewardCalculator rewardCalculator;

    @DisplayName("수익을 계산한다.")
    @Test
    void calculateProfit() {
        long expect = 20000000000L;

        lottoPrinter = new LottoPrinter();
        lottoGenerator = new LottoGenerator(startNumber, endNumber, numberCount, priceUnit, lottoPrinter);
        lottoComparator = new LottoComparator();
        rewardCalculator = new RewardCalculator();

        List<Lotto> lottos = lottoGenerator.createLottos(price);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        Map<LottoRank, Integer> winningCounts = lottoComparator.createWinningCounts(lottos, winningNumbers, bonus);
        double profit = rewardCalculator.calculateProfit(winningCounts, price);
        long profitPercent = (long) (profit * 100);

        assertEquals(expect, profitPercent);
    }
}
