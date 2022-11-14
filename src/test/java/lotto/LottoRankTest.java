package lotto;

import static lotto.LottoRank.RANK1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {
    @DisplayName("당첨 번호와 6개가 일치할 경우 RANK1이다")
    @Test
    void findRank() {
        LottoRank rank = LottoRank.findRank(6);
        Assertions.assertThat(rank).isEqualTo(RANK1);
    }

    @DisplayName("로또 당첨 순위에 따른 당첨 금액 총합을 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"RANK1, 2000000000", "RANK2, 30000000", "RANK3, 1500000", "RANK4, 50000", "RANK5, 5000"})
    void calculateTotalAmount(LottoRank rank, int expected) {
        int totalAmount = rank.calculateTotalAmount(1);
        Assertions.assertThat(totalAmount).isEqualTo(expected);
    }
}