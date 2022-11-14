package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호 범위가 1~45가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoByRangeOfNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 보너스 번호를 포함하는가?")
    @Test
    void isContainsBonusNumber() {
        boolean containsNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6)).containsNumber(6);
        Assertions.assertEquals(true, containsNumber);
    }

    @DisplayName("당첨번호와 일치하는 번호가 몇개인가?")
    @Test
    void howManyMatchingNumberWithWinningNumber() {
        int num = new Lotto(List.of(1, 2, 3, 4, 5, 6)).countMatchingNumber(new Lotto(List.of(1, 2, 4, 5, 6, 8)));
        Assertions.assertEquals(5, num);
    }
}
