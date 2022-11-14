package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    private Result result = new Result();

    @DisplayName("로또 번호가 {1,2,3,4,5,6}이고 당첨 번호가 {1,2,3,4,5,7}이면 5를 반환한다.")
    @Test
    void calculateMatchCount() {
        // given
        Lotto perchasedLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Lotto winningLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7)));

        // when
        int matchCount = result.checkMatchCount(perchasedLotto, winningLotto);

        // then
        assertThat(matchCount).isEqualTo(5);
    }

    @DisplayName("로또 번호{1,2,3,4,5,6}에 보너스 번호(3)가 포함되면 true 반환한다.")
    @Test
    void checkMatchBonusReturnTrue() {
        // given
        Lotto perchasedLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        int bonus = 3;

        // when
        boolean match = result.matchBonus(perchasedLotto, bonus);

        // then
        assertThat(match).isTrue();
    }

    @DisplayName("로또 번호{1,2,3,4,5,6}에 보너스 번호(8)가 포함되지 않으면 false를 반환한다.")
    @Test
    void checkMatchBonusReturnFalse() {
        // given
        Lotto perchasedLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        int bonus = 8;

        // when
        boolean match = result.matchBonus(perchasedLotto, bonus);

        // then
        assertThat(match).isFalse();
    }

    @DisplayName("로또 번호와 당첨 번호 중 5개가 일치하고 로또 번호가 보너스 번호를 포함하면 2등이다.")
    @Test
    void createRankSecond() {
        // given
        int matchCount = Rank.SECOND.getCorrectCount();
        boolean matchBonus = true;

        // when
        result.initWinningRank();
        result.updateResult(matchCount, matchBonus);

        // then
        assertThat(result.getResult().get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.getResult().get(Rank.THIRD)).isEqualTo(0);
    }

    @DisplayName("로또 번호와 당첨 번호 중 5개가 일치하고 로또 번호가 보너스 번호를 포함하지 않으면 3등이다.")
    @Test
    void createRankThird() {
        // given
        int matchCount = Rank.THIRD.getCorrectCount();
        boolean matchBonus = false;

        // when
        result.initWinningRank();
        result.updateResult(matchCount, matchBonus);

        // then
        assertThat(result.getResult().get(Rank.SECOND)).isEqualTo(0);
        assertThat(result.getResult().get(Rank.THIRD)).isEqualTo(1);
    }
}