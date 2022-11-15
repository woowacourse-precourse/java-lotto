package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Report;
import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReportTest {

    @DisplayName("로또 전체 금액 확인 테스트")
    @Test
    void lottoTotalPrizeCheck() {
        List<Integer> lottoFirst = Arrays.asList(1, 2, 3, 4, 5, 7); // 5개 일치(보너스 X): 3등, 1,500,000
        List<Integer> lottoSecond = Arrays.asList(1, 2, 3, 4, 10, 11); // 4개 일치: 4등, 50_000
        List<Lotto> allLotto = new ArrayList<>();
        Winning.numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 10);
        allLotto.add(new Lotto(lottoFirst));
        allLotto.add(new Lotto(lottoSecond));

        int result = Report.totalPrize(allLotto);
        assertThat(result).isEqualTo(1550000);
    }

    @DisplayName("로또 수익률 확인 테스트")
    @Test
    void lottoReturnRate() {
        double result = Report.returnRate(8000, 5000);
        assertThat(result).isEqualTo(62.5);
    }

    @DisplayName("로또 총 당첨 개수 확인 테스트")
    @Test
    void lottoWinningCount() {
        Report report = new Report(Rank.Two);
        report.winningCount = new Integer[]{0, 0, 0, 0, 0, 0};
        report.winningCount(5, true);
        Integer[] answer = {0, 0, 0, 0, 1, 0};
        assertThat(report.winningCount).isEqualTo(answer);
    }
}