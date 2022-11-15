package lotto;

import static lotto.matchedCountMessage.THREE_MATCH;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticTest {
    Statistic statistic;
    @BeforeEach
    public void beforeEach() {
       statistic = new Statistic();
    }

    @Test
    @DisplayName("정확히 추가되는 지 확인 ")
    public void checkaddMatchedCount() {
        statistic.addMatchedCount(THREE_MATCH.getMatchNumber());
        assertThat(statistic.getMatchedCount().get(THREE_MATCH.getMatchNumber())).isEqualTo(1);
    }

    @Test
    @DisplayName("Winning Number 정확히 구하는 지 확인")
    public void checkCountEachLottoWinningNumber() {
        Lotto list = new Lotto(List.of(1, 2, 3, 4,5,6));
        Lotto list2 = new Lotto(List.of(1, 2, 3, 4,5,6));
        int WinningSum = statistic.CountEachLottoWinningNumber( list,list2);
        assertThat(WinningSum).isEqualTo(6);
    }

    @Test
    @DisplayName("Winning Number 에 숫자 포함하는지 확인")
    public void checkCountEachLottoNumber() {
        Lotto list = new Lotto(List.of(1, 2, 3, 4,5,6));
        int num = 2;
        assertThat(statistic.checkEachLottoBonusNumber( list, num)).isEqualTo(true);
    }

    @Test
    @DisplayName("Profit 정확히 구하는 지 확인")
    public void checkPrintLotto() {
        int purchasedMoney = 8000;
        int num = statistic.getMatchedCount().getOrDefault(THREE_MATCH.getMatchNumber(),0);
        double price = num *  THREE_MATCH.getMatchNumberPrice();
        double profit = price/purchasedMoney *100;
        assertThat(statistic.getProfit(8000)).isEqualTo(profit);
    }


}
