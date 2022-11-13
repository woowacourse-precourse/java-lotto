package lotto.model;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    void 당첨번호_입력_테스트() {
        String inputWinningLottoNumbers = "1,2,3,4,5,6";
        WinningLotto winningLotto = new WinningLotto(inputWinningLottoNumbers);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.getWinningLotto().get()).isEqualTo(lotto.get());
    }

    @Test
    void 당첨_번호_입력시_입력형식을_준수해야한다() {
        String inputWinningLottoNumbers = "1, 2, 3, 4, 5, 6";
        assertThatThrownBy(() -> new WinningLotto(inputWinningLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호의_범위는_1부터_45까지_이다() {
        String inputWinningLottoNumbers = "0, 1, 2, 3, 4, 5";
        assertThatThrownBy(() -> new WinningLotto(inputWinningLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호는_서로_중복될_수_없다() {
        String inputWinningLottoNumbers = "1, 1, 2, 3, 4, 5";
        assertThatThrownBy(() -> new WinningLotto(inputWinningLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}