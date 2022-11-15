package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PickTest {
    @DisplayName("로또 추첨 결과를 집계할 수 있다.")
    @Test
    void totalLottoes() {
        List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        Pick pick = new Pick(answer, bonus);
        List<Lotto> lottoes = List.of(
                new Lotto(List.of(1, 2, 9, 8, 5, 6)), // 4개 -> 4등
                new Lotto(List.of(1, 2, 3, 4, 5, 12)), // 5개 -> 3등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 5개 + 보너스 -> 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 6개 -> 1등
                new Lotto(List.of(11, 12, 3, 4, 5, 6)), // 4개 -> 4등
                new Lotto(List.of(11, 12, 13, 14, 15, 16))); // 0개 -> 미당첨(0)
        List<Integer> scores;

        pick.drawLottoes(lottoes);
        scores = pick.getScores();
        assertThat(scores).isEqualTo(List.of(1, 1, 1, 1, 2, 0));
    }

    @DisplayName("당첨된게 없더라도 널이 아닌 0으로 초기화된 점수목록을 얻어야 한다.")
    @Test
    void totalLottoesWithNonMatched() {
        List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        Pick pick = new Pick(answer, bonus);
        List<Lotto> lottoes = List.of(
                new Lotto(List.of(9, 10, 11, 12, 15, 16)),
                new Lotto(List.of(9, 10, 11, 12, 15, 16)),
                new Lotto(List.of(9, 10, 11, 12, 15, 16)),
                new Lotto(List.of(9, 10, 11, 12, 15, 16)),
                new Lotto(List.of(9, 10, 11, 12, 15, 16)),
                new Lotto(List.of(9, 10, 11, 12, 15, 16))); // 0개 -> 미당첨(0)
        List<Integer> scores;

        pick.drawLottoes(lottoes);
        scores = pick.getScores();
        assertThat(scores).isEqualTo(List.of(6, 0, 0, 0, 0, 0));
    }

    @DisplayName("수익률을 계산할 수 있다._1")
    @Test
    void calculateRateOfReturn() {
        List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        Pick pick = new Pick(answer, bonus);
        List<Lotto> lottoes = List.of(
                new Lotto(List.of(1, 2, 3, 8, 9, 10)), // 3개 -> 5등
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))); // 0개 -> 미당첨(0)
        List<Integer> scores;
        double rateOfReturn;

        pick.drawLottoes(lottoes);
        rateOfReturn = pick.getRateOfReturn(8000);
        assertThat(rateOfReturn).isEqualTo(62.5);
    }

    @DisplayName("수익률을 계산할 수 있다._2")
    @Test
    void calculateRateOfReturn2() {
        List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        Pick pick = new Pick(answer, bonus);
        List<Lotto> lottoes = List.of(
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))); // 0개 -> 미당첨(0)
        List<Integer> scores;
        double rateOfReturn;

        pick.drawLottoes(lottoes);
        rateOfReturn = pick.getRateOfReturn(8000);
        assertThat(rateOfReturn).isEqualTo(0.0);
    }

    @DisplayName("수익률을 계산할 수 있다._3")
    @Test
    void calculateRateOfReturn3() {
        List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        Pick pick = new Pick(answer, bonus);
        List<Lotto> lottoes = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))); // 0개 -> 미당첨(0)
        List<Integer> scores;
        double rateOfReturn;

        pick.drawLottoes(lottoes);
        rateOfReturn = pick.getRateOfReturn(8000);
        assertThat(rateOfReturn).isEqualTo(25_000_000.0);
    }
}