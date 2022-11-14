package lotto;

import lotto.enums.Rank;
import lotto.model.Draw;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DrawTest {
    @DisplayName("Draw 생성 후 WinningStats가 정확한 값인지 확인한다.")
    @Test
    void getWinningStats() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNum = 7;
        Draw draw = new Draw(winningLotto,bonusNum);

        List<Lotto> lottoPaper = new ArrayList<>(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 12)),
                new Lotto(List.of(1, 2, 3, 4, 11, 12)),
                new Lotto(List.of(1, 2, 3, 12, 13, 14)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))
                ));

        // when
        Map<Rank, Integer> winningStats = draw.getWinningStats(lottoPaper);

        // then
        assertThat(winningStats.entrySet().stream()
                .map(w -> winningStats.get(w.getKey()))
                .allMatch(v -> v.equals(1)))
                .isTrue();
    }

    @DisplayName("Draw에 제시된 bonusNum가 1,45 숫자보다 크면 예외가 발생한다.")
    @Test
    void createDrawByOverRangeBonusNum() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNum = 46;

        assertThatThrownBy(() -> new Draw(lotto,bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Draw에 제시된 bonusNum가 1,45 숫자보다 작으면 예외가 발생한다.")
    @Test
    void createDrawByUnderRangeBonusNum() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNum = 0;

        assertThatThrownBy(() -> new Draw(lotto,bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
