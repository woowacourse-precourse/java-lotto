package lotto;

import domain.Buyer;
import domain.Lotto;
import domain.WinningNumber;
import domain.Winnings;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class BuyerTest {

    private Buyer buyer;
    private WinningNumber winningNumber;

    @BeforeEach
    void init() {
        buyer = new Buyer(1000);
        winningNumber = new WinningNumber("1,2,3,4,5,6", 7);
        buyer.putWinningStatistics(winningNumber);
    }

    @Test
    @DisplayName("당첨금 HashMap 구성 테스트")
    void putWinningStatisticsTest() {
        Map<Winnings, Integer> winningStatistics = buyer.getWinningStatistics();
        List<Lotto> buyerLotto = buyer.getBuyerLotto();
        Winnings winnings = buyerLotto.get(0).compare(winningNumber);
        Assertions.assertThat(winningStatistics.get(winnings)).isEqualTo(1);
    }

    @Test
    @DisplayName("calculateReturnRate() 수익률 테스트")
    void calculateReturnRateTest() {
        String s = buyer.calculateReturnRate();
        List<Lotto> buyerLotto = buyer.getBuyerLotto();
        Winnings winnings = buyerLotto.get(0).compare(winningNumber);
        Assertions.assertThat(String.format("%.1f", (double)winnings.getPrice()*100 / buyer.getPurchaseAmount())).isEqualTo(s);
    }

}
