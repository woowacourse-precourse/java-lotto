package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinsTest {

    @DisplayName("당첨된 번호의 개수와 보너스 번호가 주어지면 당첨 통계를 얻는다.")
    @Test
    void 당첨된_번호_개수와_보너스_번호가_주어지면_결과를_얻는다() {
        // given
        String result = "3개 일치 (5,000원) - %d개\n" +
                "4개 일치 (50,000원) - %d개\n" +
                "5개 일치 (1,500,000원) - %d개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                "6개 일치 (2,000,000,000원) - %d개";

        // when
        Wins.countWinningLotto(3, false);
        Wins.countWinningLotto(3, true);
        Wins.countWinningLotto(4, false);
        Wins.countWinningLotto(5, true);

        // then
        assertThat(Wins.getWinningStats())
                .isEqualTo(String.format(result, 2, 1, 0, 1, 0));
    }

    @DisplayName("구입 금액에 따른 수익률을 얻는다.")
    @Test
    void 구입_금액이_주어지면_수익률을_얻는데_성공한다() {
        // given
        int purchaseAmount = 60000;
        Wins.countWinningLotto(4, false);
        double expected = 0.8;

        // when
        double actual = Wins.getProfitRate(purchaseAmount);

        // then
        assertThat(String.format("%.1f", actual)).isEqualTo(String.format("%.1f", expected));
    }
}