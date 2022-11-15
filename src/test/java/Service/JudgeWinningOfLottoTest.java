package Service;

import lotto.Ranking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeWinningOfLottoTest {

    @DisplayName("로또 숫자 3개 일치")
    @Test
    void compareMatchThreeNumber() {
        JudgeWinningOfLotto judgeWinningOfLotto = new JudgeWinningOfLotto();

        int match = judgeWinningOfLotto.compareMatchNumbers(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 44, 35, 26));
        int result = 3;

        assertThat(match).isEqualTo(result);
    }

    @DisplayName("로또 숫자 0개 일치")
    @Test
    void comparenotMatch() {
        JudgeWinningOfLotto judgeWinningOfLotto = new JudgeWinningOfLotto();

        int match = judgeWinningOfLotto.compareMatchNumbers(List.of(1, 2, 3, 4, 5, 6), List.of(11, 12, 13, 14, 15, 16));
        int result = 0;

        assertThat(match).isEqualTo(result);

    }

    @DisplayName("보너스 번호 포함")
    @Test
    void containBounsNumber() {
        JudgeWinningOfLotto judgeWinningOfLotto = new JudgeWinningOfLotto();

        boolean bonusStatus = judgeWinningOfLotto.isContainBounsNumber(List.of(1, 2, 3, 4, 5, 6), 6);
        boolean result = true;

        assertThat(bonusStatus).isEqualTo(result);
    }

    @DisplayName("보너스 번호 미포함")
    @Test
    void notContainBounsNumber() {
        JudgeWinningOfLotto judgeWinningOfLotto = new JudgeWinningOfLotto();

        boolean bonusStatus = judgeWinningOfLotto.isContainBounsNumber(List.of(1, 2, 3, 4, 5, 6), 10);
        boolean result = false;

        assertThat(bonusStatus).isEqualTo(result);
    }

    @DisplayName("당첨 순위 2등")
    @Test
    void findRankSecond() {
        JudgeWinningOfLotto judgeWinningOfLotto = new JudgeWinningOfLotto();

        Ranking lottoRanking = judgeWinningOfLotto.findLottoRanking(5, true);
        Ranking result = Ranking.SECOND;

        assertThat(lottoRanking).isEqualTo(result);

    }

    @DisplayName("당첨 순위 3등")
    @Test
    void findRankThrid() {
        JudgeWinningOfLotto judgeWinningOfLotto = new JudgeWinningOfLotto();

        Ranking lottoRanking = judgeWinningOfLotto.findLottoRanking(5, false);
        Ranking result = Ranking.THRID;

        assertThat(lottoRanking).isEqualTo(result);

    }

}