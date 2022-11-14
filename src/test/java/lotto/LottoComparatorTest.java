package lotto;

import lotto.data.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoComparator;
import lotto.domain.LottoGenerator;
import lotto.presentation.LottoPrinter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoComparatorTest {
    private final int startNumber = 1;
    private final int endNumber = 6;
    private final int numberCount = 6;
    private final int priceUnit = 1000;
    private final int price = 8000;
    private LottoGenerator lottoGenerator;
    private LottoPrinter lottoPrinter;


    @DisplayName("로또 번호와 당첨 번호, 보너스 번호가 있을 때 각 등수에 해당하는 로또 개수를 알맞게 파악한다.")
    @Test
    void createWinningCounts() {
        int expected = 8;

        lottoPrinter = new LottoPrinter();
        lottoGenerator = new LottoGenerator(startNumber, endNumber, numberCount, priceUnit, lottoPrinter);
        List<Lotto> lottos = lottoGenerator.createLottos(price);

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        LottoComparator lottoComparator = new LottoComparator();
        Map<LottoRank, Integer> winningCounts = lottoComparator.createWinningCounts(lottos, winningNumbers, bonus);

        int winningCount = winningCounts.get(LottoRank.FIRST);
        assertEquals(expected, winningCount);
    }
}