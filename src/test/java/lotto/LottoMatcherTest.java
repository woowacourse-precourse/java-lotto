package lotto;

import lotto.domain.Lotto;
import lotto.constant.Rank;
import lotto.domain.WinningLotto;
import lotto.participant.LottoMatcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.constant.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMatcherTest {

    @Test
    @DisplayName("결과 처리 테스트")
    void matchAllLottosTest() {
        // given
        LottoMatcher matcher = new LottoMatcher();
        List<Lotto> publishedLottos = List.of(
                new Lotto(Arrays.asList(11, 13, 29, 42, 19, 33)),
                new Lotto(Arrays.asList(28, 29, 42, 33, 15, 11)),
                new Lotto(Arrays.asList(24, 40, 25, 32, 4, 14)),
                new Lotto(Arrays.asList(33, 40, 29, 38, 28, 31)),
                new Lotto(Arrays.asList(33, 32, 41, 6, 15, 9)),
                new Lotto(Arrays.asList(8, 25, 28, 18, 22, 27)),
                new Lotto(Arrays.asList(11, 28, 15, 29, 42, 10)),
                new Lotto(Arrays.asList(27, 3, 13, 6, 43, 21)),
                new Lotto(Arrays.asList(24, 33, 34, 7, 45, 42)),
                new Lotto(Arrays.asList(15, 28, 42, 11, 33, 21))
        );
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(33, 15, 29, 42, 28, 11), 10);

        // when
        Map<Rank, Integer> actualResults = matcher.matchAllLottos(publishedLottos, winningLotto);
        Map<Rank, Integer> expectedResults = Map.of(
                FIRST_SIX_MATCHED, 1,
                SECOND_FIVE_WITH_BONUS, 1,
                THIRD_FIVE_MATCHED, 1,
                FOURTH_FOUR_MATCHED, 1,
                FIFTH_THREE_MATCHED, 1);

        // then
        assertThat(actualResults).isEqualTo(expectedResults);
    }
}