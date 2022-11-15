package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import static lotto.model.Lotto.MatchInfo.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적으로 수행되는 경우.")
    @Test
    void calculateLottoResultByProperInput() {
        List<List<Integer>> generatedRandomLotto1 = List.of(List.of(1, 2, 3, 7, 8, 9));
        List<List<Integer>> generatedRandomLotto2 = List.of(List.of(4, 5, 6, 7, 8, 9), List.of(1, 2, 3, 4, 7, 8),
                List.of(1, 2, 3, 4, 5, 9), List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 5, 6));
        List<Integer> userInput = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        Lotto lotto = new Lotto(userInput);
        assertAll(
                () -> assertThat(lotto.calculateLottoStatistics(generatedRandomLotto1, bonus)).
                        isEqualTo(Map.of(MATCH_THREE, 1, MATCH_FOUR, 0, MATCH_FIVE, 0,
                                MATCH_FIVE_WITH_BONUS, 0, MATCH_SIX, 0)),
                () -> assertThat(lotto.calculateLottoStatistics(generatedRandomLotto2, bonus)).
                        isEqualTo(Map.of(MATCH_THREE, 1, MATCH_FOUR, 1, MATCH_FIVE, 1,
                                MATCH_FIVE_WITH_BONUS, 1, MATCH_SIX, 1))
        );
    }

    @DisplayName("로또 금액 계산.")
    @Test
    void calculateWinningAmount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Map<Lotto.MatchInfo, Integer> lottoStatistics = Map.of(MATCH_THREE, 1, MATCH_FOUR, 1,
                MATCH_FIVE, 1, MATCH_FIVE_WITH_BONUS, 1, MATCH_SIX, 1);

        assertThat(lotto.calculateWinningAmount(lottoStatistics)).isEqualTo(BigInteger.valueOf(2031555000));
    }

    @DisplayName("이율 계산 정상 수행.")
    @Test
    void calculateProfitRatio() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BigInteger income1 = BigInteger.valueOf(9000);
        BigInteger income2 = BigInteger.valueOf(10000);
        int expense = 5000;

        assertAll(()->assertThat(lotto.calculateProfitRatio(income1, expense)).isEqualTo(BigDecimal.valueOf(180.0)),
                ()->assertThat(lotto.calculateProfitRatio(income2, expense)).isEqualTo(BigDecimal.valueOf(200.0)));
    }
}
