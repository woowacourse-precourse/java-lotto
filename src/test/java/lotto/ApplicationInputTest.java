package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ApplicationInputTest {

    @Test
    void cost_기능_테스트 () {
        int cost = Application.inputCost("8000");
        assertThat(cost).isEqualTo(8000);
    }

    @Test
    void cost_예외_문자입력 () {
        assertThatThrownBy(() -> Application.inputCost("a800")).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void WinningLottoNums_기능_테스트 () {
        assertThat(Application.inputWinningLottoNums(" 1,2,3,4,5,6\n")).
                isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    void WinningLottoNums_예외_문자입력 () {
        assertThatThrownBy(() -> Application.inputWinningLottoNums(" 1, 2,3,4,5,6  \n")).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void WinningLottoNums_예외_숫자6개초과 () {
        assertThatThrownBy(() -> Application.inputWinningLottoNums(" 1,2,3,4,5,6,7  \n")).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void WinningLottoNums_예외_숫자범위초과 () {
        assertThatThrownBy(() -> Application.inputWinningLottoNums(" 1,2,3,4,5,46  \n")).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void WinningBonusNum_기능_테스트 () {
        assertThat(Application.inputWinningBonusNum("2  \n")).
                isEqualTo(2);
    }

    @Test
    void WinningBonusNum_문자입력 () {
        assertThatThrownBy(() -> Application.inputCost("a2")).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void WinningBonusNum_숫자범위초과 () {
        assertThatThrownBy(() -> Application.inputCost("46")).
                isInstanceOf(IllegalArgumentException.class);
    }
}
