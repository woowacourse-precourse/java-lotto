package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {
    @Test
    void 당첨번호_정상입력() {
        new LottoNumber("1,2,3,4,5,6", "7");
    }

    @Test
    void 당첨번호_비정상입력_숫자x() {
        assertThatThrownBy(() -> new LottoNumber("1*,2,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }

    @Test
    void 당첨번호_비정상입력_숫자범위초과() {
        assertThatThrownBy(() -> new LottoNumber("1,2,3,4,5,46", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1에서 45사이의 숫자를 입력해주세요.");
    }

    @Test
    void 당첨번호_비정상입력_숫자범위미달() {
        assertThatThrownBy(() -> new LottoNumber("1,2,3,4,5,0", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1에서 45사이의 숫자를 입력해주세요.");
    }

    @Test
    void 당첨번호_비정상입력_공백포함() {
        assertThatThrownBy(() -> new LottoNumber("1,2,3,4,5, ", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }

    @Test
    void 당첨번호_비정상입력_숫자뒤공백포함() {
        assertThatThrownBy(() -> new LottoNumber("1 ,2,3,4,5,6", " "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }
}