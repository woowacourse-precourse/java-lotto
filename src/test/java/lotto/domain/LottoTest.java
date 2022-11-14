package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_값_개수_세기() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.countSameNumbers(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(6);
        assertThat(lotto.countSameNumbers(List.of(1, 2, 3, 4, 5, 9))).isEqualTo(5);
        assertThat(lotto.countSameNumbers(List.of(1, 2, 3, 4, 8, 9))).isEqualTo(4);
        assertThat(lotto.countSameNumbers(List.of(1, 2, 3, 7, 8, 9))).isEqualTo(3);
        assertThat(lotto.countSameNumbers(List.of(1, 2, 10, 7, 8, 9))).isEqualTo(2);
        assertThat(lotto.countSameNumbers(List.of(1, 45, 10, 7, 8, 9))).isEqualTo(1);
    }

    @Test
    void 사용자로또와_당첨숫자와_보너스숫자로_순위찾기_FIRST() {
        Lotto userLotto = new Lotto(List.of(11, 23, 28, 30, 39, 45));

        Lotto winningLotto = new Lotto(List.of(11, 23, 28, 30, 39, 45));
        Integer bonusNumber = 8;
        Ranking result = Ranking.FIRST;
        assertThat(userLotto.getRankingByRightCountAndHasBonusNumber(winningLotto, bonusNumber)).isEqualTo(result);
    }

    @Test
    void 사용자로또와_당첨숫자와_보너스숫자로_순위찾기_SECOND() {
        Lotto userLotto = new Lotto(List.of(11, 23, 28, 30, 39, 45));

        Lotto winningLotto = new Lotto(List.of(11, 23, 28, 30, 39, 7));
        Integer bonusNumber = 45;
        Ranking result = Ranking.SECOND;
        assertThat(userLotto.getRankingByRightCountAndHasBonusNumber(winningLotto, bonusNumber)).isEqualTo(result);
    }

    @Test
    void 사용자로또와_당첨숫자와_보너스숫자로_순위찾기_THIRD() {
        Lotto userLotto = new Lotto(List.of(11, 23, 28, 30, 39, 45));

        Lotto winningLotto = new Lotto(List.of(11, 23, 28, 30, 39, 18));
        Integer bonusNumber = 3;
        Ranking result = Ranking.THIRD;
        assertThat(userLotto.getRankingByRightCountAndHasBonusNumber(winningLotto, bonusNumber)).isEqualTo(result);
    }

    @Test
    void 사용자로또와_당첨숫자와_보너스숫자로_순위찾기_FOURTH() {
        Lotto userLotto = new Lotto(List.of(11, 23, 28, 30, 39, 45));

        Lotto winningLotto = new Lotto(List.of(8, 23, 28, 30, 14, 45));
        Integer bonusNumber = 11;
        Ranking result = Ranking.FOURTH;
        assertThat(userLotto.getRankingByRightCountAndHasBonusNumber(winningLotto, bonusNumber)).isEqualTo(result);
    }

    @Test
    void 사용자로또와_당첨숫자와_보너스숫자로_순위찾기_FIFTH() {
        Lotto userLotto = new Lotto(List.of(8, 21, 28, 30, 14, 45));

        Lotto winningLotto = new Lotto(List.of(8, 23, 28, 30, 19, 43));
        Integer bonusNumber = 40;
        Ranking result = Ranking.FIFTH;
        assertThat(userLotto.getRankingByRightCountAndHasBonusNumber(winningLotto, bonusNumber)).isEqualTo(result);
    }
}
