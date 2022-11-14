package lotto.domain.rule;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGroup;
import lotto.domain.lotto.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    @DisplayName("복권 여러 장 당첨 테스트")
    @Test
    void getLottoResults() {

        LottoGroup lottoGroup = new LottoGroup(
                List.of(
                        new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                        new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                        new Lotto(List.of(1, 2, 3, 4, 36, 7)),
                        new Lotto(List.of(1, 3, 4, 2, 5, 9)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7))
                )
        );

        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", "7");

        Rule rule = new Rule();
        Map<Rank, Long> lottoResults = rule.getLottoResults(lottoGroup, winningNumber);

        assertAll(
                () -> assertThat(lottoResults.get(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(lottoResults.get(Rank.SECOND)).isEqualTo(1),
                () -> assertThat(lottoResults.get(Rank.THIRD)).isEqualTo(1),
                () -> assertThat(lottoResults.get(Rank.FOURTH)).isEqualTo(1),
                () -> assertThat(lottoResults.get(Rank.FIFTH)).isEqualTo(0),
                () -> assertThat(lottoResults.get(Rank.FAIL)).isEqualTo(2)
        );
    }

}