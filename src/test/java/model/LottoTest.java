package model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static model.Win.FIFTH;
import static model.Win.FIRST;
import static model.Win.FOURTH;
import static model.Win.SECOND;
import static model.Win.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    void 로또_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
    }

    @Test
    void 로또_번호가_1보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 범위여야 합니다.");

    }

    @Test
    void 로또_번호가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(46, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 범위여야 합니다.");
    }

    @Test
    void 로또_번호를_오름차순으로_생성한다() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers()).isSorted();
    }

    static Stream<Arguments> winningResult() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        BonusNumber bonusNumber = new BonusNumber(7);
        BonusNumber winningBonusNumber = new BonusNumber(6);
        return Stream.of(
                Arguments.of(lotto, new WinningLotto(lotto, bonusNumber), FIRST),

                Arguments.of(lotto, new WinningLotto(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 16))), winningBonusNumber), SECOND),

                Arguments.of(lotto, new WinningLotto(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 16))), bonusNumber), THIRD),

                Arguments.of(lotto, new WinningLotto(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 15, 16))), bonusNumber), FOURTH),

                Arguments.of(lotto, new WinningLotto(new Lotto(new ArrayList<>(List.of(1, 2, 3, 14, 15, 16))), bonusNumber), FIFTH)
        );
    }

    @ParameterizedTest(name = "{index}  ranking = {2}")
    @MethodSource("winningResult")
    void 사용자가_구매한_로또_번호와_당첨_번호를_비교한다(Lotto lotto, WinningLotto winningLotto, Win win) {
        WinningResult inputWinningResult = lotto.getWinningResult(winningLotto);
        Map<Win, Integer> winningResult = inputWinningResult.getWinningResult();

        assertEquals(winningResult.size(), 1);
        assertEquals(winningResult.get(win), 1);
    }
}
