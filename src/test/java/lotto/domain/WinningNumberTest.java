package lotto.domain;

import org.junit.jupiter.api.Test;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.*;

class WinningNumberTest {
    @Test
    void _6개의_입력_실패() {
        String str = "1,2,3,4,a,6";
        StringTokenizer st = new StringTokenizer(str, ",");
        assertThat(st.countTokens() == 6).isTrue();
    }

    @Test
    void _5개의_입력_성공() {
        String str = "1,2,3,4,aaa";
        StringTokenizer st = new StringTokenizer(str, ",");
        assertThat(st.countTokens() == 6).isFalse();
    }

    /*@Test
    void 당첨_번호_입력_성공() {
        WinningNumber wn = new WinningNumber();
        wn.inputWinningNumber("1,2,3,4,5,6");
        assertThat(wn.getWinningNumber()).contains(1, 2, 3, 4, 5, 6);
    }*/

    @Test
    void 당첨_번호_입력_실패1() {
        WinningNumber wn = new WinningNumber();
        assertThatThrownBy(() -> wn.inputWinningNumber("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_입력_실패2() {
        WinningNumber wn = new WinningNumber();
        assertThatThrownBy(() -> wn.inputWinningNumber("1,2,3,4,5a,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}