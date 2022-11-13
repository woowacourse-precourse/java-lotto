package lotto;

import static lotto.domain.Lotto.createLotto;
import static lotto.view.WinningInput.getWinningResult;
import static lotto.view.WinningInput.winningCount;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

import java.util.List;

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

    @DisplayName("로또 생성 메서드는 6개의 번호를 생성")
    @Test
    void createLottoTestSize() {
        List<Lotto> lotto = new ArrayList<>(List.of(createLotto()));
        assertThat(lotto.get(0).getNumbers().size() == 6).isTrue();
    }

    @DisplayName("로또 번호와 일치하는 숫자 개수를 구하는 메서드 테스트")
    @Test
    void getWinningResultTest() {
        getWinningResult(List.of(List.of(8, 21, 23, 41, 42, 43), List.of(3, 5, 11, 16, 32, 38)), List.of(8, 21, 23, 30, 32,38));
        assertThat(winningCount == 3).isTrue();
    }
}
