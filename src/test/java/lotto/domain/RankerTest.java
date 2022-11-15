package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RankerTest {
    @DisplayName("일치하는 숫자가 3개 미만인 경우 꽝을 반환한다.")
    @Test
    void matchZero() {
        Ranker ranker = new Ranker(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        WinningResult none = WinningResult.NONE;
        assertThat(ranker.rank(lotto)).isEqualTo(none);
    }

    @DisplayName("일치하는 숫자가 5개에 보너스 번호가 일치하지 않는 경우 3등을 반환한다.")
    @Test
    void matchFiveNoBonus() {
        Ranker ranker = new Ranker(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        WinningResult third = WinningResult.THIRD;
        assertThat(ranker.rank(lotto)).isEqualTo(third);
    }

    @DisplayName("일치하는 숫자가 5개에 보너스 번호가 일치하는 경우 2등을 반환한다.")
    @Test
    void matchFiveWithBonus() {
        Ranker ranker = new Ranker(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningResult second = WinningResult.SECOND;
        assertThat(ranker.rank(lotto)).isEqualTo(second);
    }

    @DisplayName("로또 리스트에 대해 3등을 하나 4등을 두개 반환한다.")
    @Test
    void matchLottoMap() {
        Ranker ranker = new Ranker(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 10, 15)),
                new Lotto(List.of(1, 2, 3, 4, 11, 12)),
                new Lotto(List.of(3, 4, 5, 6, 20, 21)));
        Map<WinningResult, Integer> results = ranker.rankTotal(lottos);
        assertThat(results.get(WinningResult.THIRD)).isEqualTo(1);
        assertThat(results.get(WinningResult.FOURTH)).isEqualTo(2);
    }
}
