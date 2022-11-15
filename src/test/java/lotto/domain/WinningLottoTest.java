package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("당첨 번호가 1~45사이의 수가 아닐 경우 에러가 발생한다.")
    @Test
    void createLottoOverNumberRange() {
        WinningLotto winningLotto = new WinningLotto();

        String[] arr = {"1", "2", "3", "4", "5", "46"};
        assertThatThrownBy(() -> winningLotto.stringArrayToIntegerList(arr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열을 , 로 split 했을 때 잘 분리되는지 확인한다.")
    @Test
    void splitCommaTest() {
        assertThat(new WinningLotto().splitByComma("1,2,3")).isEqualTo(new String[]{"1", "2", "3"});
    }

    @DisplayName("문자열을 , 로 split 했을 때 요소가 한개여도 잘 동작하는지 확인한다.")
    @Test
    void splitCommaTestByOne() {
        assertThat(new WinningLotto().splitByComma("1")).isEqualTo(new String[]{"1"});
    }

    @DisplayName("입력된 보너스 번호가 당첨 번호에 존재할 경우 에러가 발생한다.")
    @Test
    void createBonusInWinningLotto() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6);

        assertThatThrownBy(() -> winningLotto.checkBonusInWinning())
                .isInstanceOf(IllegalArgumentException.class);
    }
}