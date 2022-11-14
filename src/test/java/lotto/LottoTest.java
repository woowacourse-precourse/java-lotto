package lotto;


import lotto.Lotto.Lotto;
import lotto.Lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("로또 번호가 범위에서 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfBoundNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 로또 번호가 들어오면 테스트는 통과한다.")
    @Test
    void createLotto() {
        List<Integer> validLottoNumbers = List.of(1, 12, 13, 31, 32, 45);
        Lotto lotto = new Lotto(validLottoNumbers);
    }

    @DisplayName("당첨 로또는 기존 로또에서 보너스 번호를 추가로 가진다.")
    @Test
    void createWinningLotto() {
        List<Integer> validLottoNumbers = List.of(	8,9,20,25,29,33);
        Lotto lotto = new WinningLotto(validLottoNumbers,7);
    }

    @DisplayName("당첨 로또는 보너스 번호가 중첩되도 예외가 발생한다.")
    @Test
    void createDuplicationWinningLotto() {
        List<Integer> validLottoNumbers = List.of(9,18,20,22,38,44);
        Integer duplicatedSpecialNumber = 20;
        assertThatThrownBy(()-> new WinningLotto(validLottoNumbers,duplicatedSpecialNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 갖는 값의 범위가 넘어도 예외가 발생한다.")
    @Test
    void createOutOfBoundWinningLotto() {
        List<Integer> validLottoNumbers = List.of(10,14,16,18,29,35);
        Integer outOfBoundSpecialNumber1 = 46;
        Integer outOfBoundSpecialNumber2 = 0;

        assertThatThrownBy(()-> new WinningLotto(validLottoNumbers,outOfBoundSpecialNumber1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> new WinningLotto(validLottoNumbers,outOfBoundSpecialNumber2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}
