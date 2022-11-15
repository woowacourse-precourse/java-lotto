package lotto.domain;

import domain.Lotto;
import domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.Calculator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("구매 횟수가 알맞지 않은 경우 예외가 발생한다.")
    @Test
    void 구매횟수_예외발생() {
        assertThat(Calculator.getQuantity("8000")).isEqualTo(8);
    }

    @DisplayName("총 수익률 5등 당첨_1개 예외 발생")
    @Test
    void 수익률_5등_1개_예외발생() {
        int quantity = 10;
        List<Rank> ranks = Rank.getRanks();
        ranks.get(0).addCount();

        assertThat(Calculator.getYield(ranks, quantity)).isEqualTo(50.0);
    }

    @DisplayName("총 수익률 5등 당첨_2개 예외 발생")
    @Test
    void 수익률_5등_2개_예외발생() {
        int quantity = 10;
        List<Rank> ranks = Rank.getRanks();
        ranks.get(0).addCount();
        ranks.get(0).addCount();

        assertThat(Calculator.getYield(ranks, quantity)).isEqualTo(100.0);
    }

    @DisplayName("총 수익률 4등 당첨_1개 예외 발생")
    @Test
    void 수익률_4등_1개_예외발생() {
        int quantity = 10;
        List<Rank> ranks = Rank.getRanks();
        ranks.get(1).addCount();

        assertThat(Calculator.getYield(ranks, quantity)).isEqualTo(500.0);
    }

    @DisplayName("총 수익률 4등 당첨_2개 예외 발생")
    @Test
    void 수익률_4등_2개_예외발생() {
        int quantity = 10;
        List<Rank> ranks = Rank.getRanks();
        ranks.get(1).addCount();
        ranks.get(1).addCount();

        assertThat(Calculator.getYield(ranks, quantity)).isEqualTo(1000.0);
    }

    @DisplayName("총 수익률 3등 당첨_1개 예외 발생")
    @Test
    void 수익률_3등_1개_예외발생() {
        int quantity = 10;
        List<Rank> ranks = Rank.getRanks();
        ranks.get(2).addCount();

        assertThat(Calculator.getYield(ranks, quantity)).isEqualTo(15000.0);
    }

    @DisplayName("총 수익률 3등 당첨_1개_5등_당첨_1개 예외 발생")
    @Test
    void 수익률_3등_1개_5등_1개_예외발생() {
        int quantity = 10;
        List<Rank> ranks = Rank.getRanks();
        ranks.get(0).addCount();
        ranks.get(2).addCount();

        assertThat(Calculator.getYield(ranks, quantity)).isEqualTo(15050.0);
    }

    @DisplayName("총 수익률 2등 당첨_1개 예외 발생")
    @Test
    void 수익률_2등_1개_예외발생() {
        int quantity = 10;
        List<Rank> ranks = Rank.getRanks();
        ranks.get(3).addCount();

        assertThat(Calculator.getYield(ranks, quantity)).isEqualTo(300000.0);
    }

    @DisplayName("총 수익률 2등_당첨_1개_3등_당첨_1개 예외 발생")
    @Test
    void 수익률_2등_1개_3등_1개_예외발생() {
        int quantity = 10;
        List<Rank> ranks = Rank.getRanks();
        ranks.get(2).addCount();
        ranks.get(3).addCount();

        assertThat(Calculator.getYield(ranks, quantity)).isEqualTo(315000.0);
    }

    @DisplayName("총 수익률 2등 당첨_1개 예외 발생")
    @Test
    void 수익률_1등_1개_예외발생() {
        int quantity = 10;
        List<Rank> ranks = Rank.getRanks();
        ranks.get(4).addCount();

        assertThat(Calculator.getYield(ranks, quantity)).isEqualTo(20000000.0);
    }
}
