package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 1-45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByNegativeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 0, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개 맞는 경우")
    @Test
    void lottoNumberMatch6() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        assertThat(lotto.checkWin(winNumbers, bonusNumber))
                .isEqualTo(WinType.SIX);
    }

    @DisplayName("로또 번호 5개와 보너스 번호가 맞는 경우")
    @Test
    void lottoNumberMatch5AndBonus() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 10;
        assertThat(lotto.checkWin(winNumbers, bonusNumber))
                .isEqualTo(WinType.FIVE_BONUS);
    }

    @DisplayName("로또 번호가 5개 맞는 경우")
    @Test
    void lottoNumberMatch5() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        assertThat(lotto.checkWin(winNumbers, bonusNumber))
                .isEqualTo(WinType.FIVE);
    }

    @DisplayName("로또 번호가 4개 맞는 경우")
    @Test
    void lottoNumberMatch4() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 11, 10));
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        assertThat(lotto.checkWin(winNumbers, bonusNumber))
                .isEqualTo(WinType.FOUR);
    }

    @DisplayName("로또 번호가 3개 맞는 경우")
    @Test
    void lottoNumberMatch3() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 12, 11, 10));
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        assertThat(lotto.checkWin(winNumbers, bonusNumber))
                .isEqualTo(WinType.THREE);
    }

    @DisplayName("로또 번호가 당첨되지 않는 경우")
    @Test
    void lottoNumberNotWin() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 13, 12, 11, 10));
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        assertThat(lotto.checkWin(winNumbers, bonusNumber))
                .isEqualTo(WinType.NONE);
    }
}
