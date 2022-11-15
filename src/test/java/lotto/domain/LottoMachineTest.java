package lotto.domain;

import lotto.enumeration.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoMachine.calculateRateOfProfit;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("구매 금액 1000원 당 로또 한 장을 구매한다.")
    void lottoPurchase() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(4000);
        Lottos lottos = lottoMachine.purchase(purchaseMoney);

        assertThat(lottos.getLottos().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("compute 메소드는 WinningList를 생성한다.")
    void computeLottoResult() {
        Lottos lottos = new Lottos(10);
        TotalPrizeNumbers totalPrizeNumbers = new TotalPrizeNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(lottoMachine.compute(lottos, totalPrizeNumbers)).isInstanceOf(WinningList.class);
    }

    @Test
    @DisplayName("purchaseMoney 대비 로또 당첨 결과의 총 prizeMoney의 비율로 수익률을 계산한다.")
    void lottoRateOfProfit() {
        // 구매 금액: 90000원
        PurchaseMoney purchaseMoney = new PurchaseMoney(90000);
        Map<Ranking, Integer> winningInfo = new HashMap<>();

        // { 1등: 1개, 4등: 1개, 5등: 1개, 당첨 실패: 7개 }
        // 총 당첨 금액: 55000원
        winningInfo.put(Ranking.FIRST, 0);
        winningInfo.put(Ranking.SECOND, 0);
        winningInfo.put(Ranking.THIRD, 0);
        winningInfo.put(Ranking.FORTH, 1);
        winningInfo.put(Ranking.FIFTH, 1);
        winningInfo.put(Ranking.NON_WINNER, 7);

        WinningList winningList = new WinningList(winningInfo);

        // 수익률: (55000 / 90000) * 100 = 61.1
        assertThat(String.format("%.1f", calculateRateOfProfit(winningList, purchaseMoney))).isEqualTo("61.1");
    }
}