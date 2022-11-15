package lotto;

import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTest {

    @DisplayName("로또 번호의 개수가 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void lottoByOverSize() {
        assertThatThrownBy(() -> Winning.validateWinning(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Winning.validateWinning(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 숫자가 아닌 다른 문자가 있을 경우 예외가 발생한다.")
    @Test
    void lottoNumberNotInt() {
        assertThatThrownBy(() -> Winning.checkInt("1,2,3,x,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1부터 45 사이의 숫자가 아닌 것이 있을 경우 예외가 발생한다.")
    @Test
    void lottoNumberOutOfRange() {
        assertThatThrownBy(() -> Winning.checkRange(46))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Winning.checkRange(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있는 경우 예외가 발생한다.")
    @Test
    void lottoNumberOverlap() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        new Winning(numbers);
        assertThatThrownBy(() -> Winning.overlapCheck(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되는 경우 예외가 발생한다.")
    @Test
    void lottoNumberOverlapBonusNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        new Winning(numbers);
        assertThatThrownBy(() -> Winning.addBonus("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}