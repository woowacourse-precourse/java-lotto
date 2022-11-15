package lotto.util.input;

import static org.assertj.core.api.Assertions.*;

import lotto.model.WinNumbers;
import org.junit.jupiter.api.Test;

class WinNumbersTest {
    @Test
    void 중복된_값이_입력된_경우() {
        assertThatThrownBy(() -> new WinNumbers("1,2,3,4,5,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_갯수가_6개가_아닌경우_1() {
        assertThatThrownBy(() -> new WinNumbers("1,2,3,4,5,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_갯수가_6개가_아닌경우_2() {
        assertThatThrownBy(() -> new WinNumbers("1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_갯수가_6개가_아닌경우_3() {
        assertThatThrownBy(() -> new WinNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 숫자_범위_1미만() {
        assertThatThrownBy(() -> new WinNumbers("1,2,0,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_범위_45초과() {
        assertThatThrownBy(() -> new WinNumbers("1,2,3,46,47,48"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}