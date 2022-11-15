package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("당첨 내역을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"FIRST,1", "SECOND,1", "THIRD,1", "FOURTH,1", "NONE,2"})
    void getResult(Rank input, int expected) {
        List<Rank> ranks = List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.NONE, Rank.NONE);
        LottoResult lottoResult = new LottoResult(ranks);

        assertThat(lottoResult.countRank(input)).isEqualTo(expected);
    }

    @DisplayName("수익률을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"FIRST,2_000_000", "SECOND,30_000", "THIRD,1_500", "FOURTH,50", "FIFTH,5", "NONE,0"})
    void calculateYield(Rank input, double expected) {
        LottoResult lottoResult = new LottoResult(List.of(input));

        assertThat(lottoResult.calculateYield()).isEqualTo(expected);
    }
}
