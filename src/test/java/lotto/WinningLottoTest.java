package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    void 올바른_당첨번호_입력() {
        WinningLotto testCorrectLotto = new WinningLotto("1,2,3,4,5,6");
        assertThat(testCorrectLotto.getWinNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 숫자가_아닌_당첨번호_입력() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,bad,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위를_벗어난_당첨번호_입력() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자를_많이_입력() {
        assertThatThrownBy(() -> new WinningLotto("11,22,33,44,45,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자를_적게_입력() {
        assertThatThrownBy(() -> new WinningLotto("11,22,33,44,45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백이_포함된_입력() {
        assertThatThrownBy(() -> new WinningLotto("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_보너스번호_입력() {
        WinningLotto testCorrectLotto = new WinningLotto("1,2,3,4,5,6");
        testCorrectLotto.inputBonusNumber("11");
        assertThat(testCorrectLotto.getBonusNumber()).isEqualTo(11);
    }

    @Test
    void 숫자가_아닌_보너스번호_입력() {
        WinningLotto testCorrectLotto = new WinningLotto("1,2,3,4,5,6");
        assertThatThrownBy(() -> testCorrectLotto.inputBonusNumber("bad"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자범위를_벗어난_보너스번호_입력() {
        WinningLotto testCorrectLotto = new WinningLotto("1,2,3,4,5,6");
        assertThatThrownBy(() -> testCorrectLotto.inputBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백을_가진_보너스번호_입력() {
        WinningLotto testCorrectLotto = new WinningLotto("1,2,3,4,5,6");
        assertThatThrownBy(() -> testCorrectLotto.inputBonusNumber(" 45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호와_중복된_보너스번호_입력() {
        WinningLotto testCorrectLotto = new WinningLotto("1,2,3,4,5,6");
        assertThatThrownBy(() -> testCorrectLotto.inputBonusNumber("6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
