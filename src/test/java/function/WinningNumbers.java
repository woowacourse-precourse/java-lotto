package function;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import lotto.LottoDrawMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbers {

    @DisplayName("숫자가 아닌 다른 값")
    @Test
    void isNotNumber() {
        String data = "a,b,c,d,e,f";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        assertThatThrownBy(() -> new LottoDrawMachine())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]: 당첨 번호는 숫자와 ','만 입력이 가능홥니다.");
    }

    @DisplayName("','가 아닌 다른 값")
    @Test
    void isNotComma() {
        String data = "1 2 3 4 5 6";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        assertThatThrownBy(() -> new LottoDrawMachine())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]: 당첨 번호는 숫자와 ','만 입력이 가능홥니다.");
    }

    @DisplayName("빈 값('')이 존재")
    @Test
    void existsEmptyValue() {
        String data = "1,2,3,,5,6";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        assertThatThrownBy(() -> new LottoDrawMachine())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]: ',' 사이 빈 공간이 존재합니다.");
    }

    @DisplayName("6개의 숫자가 아님")
    @Test
    void isNotLength6() {
        String data = "1,2,3,4,5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        assertThatThrownBy(() -> new LottoDrawMachine())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]: 로또의 사이즈는 6이여야 합니다.");
    }

    @DisplayName("숫자의 범위가 1 ~ 45까지가 아님")
    @Test
    void isNotRangeFrom1To45() {
        String data = "1,2,3,46,5,6";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        assertThatThrownBy(() -> new LottoDrawMachine())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]: 숫자의 범위는 1 ~ 45까지여야 합니다.");
    }

    @DisplayName("중복되는 숫자 존재")
    @Test
    void duplicateNumbers() {
        String data = "1,2,3,5,5,6";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        assertThatThrownBy(() -> new LottoDrawMachine())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]: 중복되는 숫자가 존재합니다.");
    }
}
