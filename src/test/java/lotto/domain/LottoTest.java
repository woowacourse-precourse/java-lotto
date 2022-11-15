package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 작다면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위가 맞지 않는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNotInRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 60)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호에 대한 계산 후 결과를 반환한다.")
    @Test
    void computeResult_정상적인경우() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Set<Integer> winningNumbers = new HashSet<>(Set.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        Assertions.assertThat(lotto.computeResult(winningNumbers, bonusNumber)).isEqualTo(Result.SIX);
    }

    @DisplayName("로또 번호와 당첨 번호의 일치 개수가 3개 미만인 경우 결과는 NOTHING을 반환한다.")
    @Test
    void computeResult_NOTHING() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Set<Integer> winningNumbers = new HashSet<>(Set.of(7,8,9,1,2,10));
        int bonusNumber = 29;

        Assertions.assertThat(lotto.computeResult(winningNumbers, bonusNumber)).isEqualTo(Result.NOTING);
    }
}
