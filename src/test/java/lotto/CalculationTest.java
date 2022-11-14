package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationTest {
    @DisplayName("구매 금액 8000원, 수익금 5000원의 수익률 계산 테스트")
    @Test
    void getProfitRateWhenPurchase8000AndEarn5000() {
        assertThat(Calculation.getProfitRate(8000, 5000))
                .isEqualTo("62.5%");
    }

    @DisplayName("구매 금액 5000, 수익금 5000원의 수익률 계산 테스트")
    @Test
    void getProfitRateWhenPurchase5000AndEarn5000() {
        assertThat(Calculation.getProfitRate(5000, 5000))
                .isEqualTo("100.0%");
    }

    @DisplayName("로또 1등 당첨 테스트")
    @Test
    void lottoRankIs1() {
        assertThat(Calculation.compareLotto(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 4, 5, 6)))
                .isEqualTo(5);
    }

    @DisplayName("로또 2등 당첨 테스트")
    @Test
    void lottoRankIs2() {
        assertThat(Calculation.compareLotto(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 4, 5, 7)))
                .isEqualTo(4);
    }

    @DisplayName("로또 낙첨 테스트")
    @Test
    void lottoLosingTicket() {
        assertThat(Calculation.compareLotto(List.of(1, 2, 3, 4, 5, 6), 7, List.of(8, 9, 10, 11, 12, 13)))
                .isEqualTo(0);
    }

    @DisplayName("문자열을 숫자 리스트로 변환 테스트")
    @Test
    void getIntegerList() {
        assertThat(Calculation.toIntegerList("1,2,3,4,5,6")).isEqualTo(List.of(1,2,3,4,5,6));
    }
}
