package lotto;

import lotto.view.RankingView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FormattingTest {
    @Test
    @DisplayName("수익률 포맷팅 테스트 - 소수점이 0인 경우")
    void profitFormatting(){
        RankingView rankingView = new RankingView();
        assertThat(rankingView.showProfit(100)).isEqualTo("100.0");
    }

    @Test
    @DisplayName("수익률 포맷팅 테스트 - 반올림")
    void profitFormatting2(){
        RankingView rankingView = new RankingView();
        assertThat(rankingView.showProfit(20.55)).isEqualTo("20.6");
    }

    @Test
    @DisplayName("수익률 포맷팅 테스트 - 쉼표 구분자")
    void profitFormatting3(){
        RankingView rankingView = new RankingView();
        assertThat(rankingView.showProfit(10000000)).isEqualTo("10,000,000.0");
    }
}
