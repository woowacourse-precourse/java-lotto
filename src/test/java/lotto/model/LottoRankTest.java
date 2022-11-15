package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {
    @DisplayName("당첨 순위를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"0, NONE", "1, NONE", "2, NONE", "3, RANK5", "4, RANK4", "6, RANK1"})
    void findRank(int matchingCount, LottoRank expected) {
        LottoRank rank = LottoRank.findRank(matchingCount);
        assertThat(rank).isEqualTo(expected);
    }

    @DisplayName("로또 당첨 순위에 따른 당첨 금액 총합을 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"RANK1, 2000000000", "RANK2, 30000000", "RANK3, 1500000", "RANK4, 50000", "RANK5, 5000"})
    void calculateTotalAmount(LottoRank rank, int expected) {
        int totalAmount = rank.calculateTotalAmount(1);
        assertThat(totalAmount).isEqualTo(expected);
    }
}