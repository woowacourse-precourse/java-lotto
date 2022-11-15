package lotto;

import org.junit.jupiter.api.Test;

import static constants.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoDrawingTest {
    @Test
    void 당첨번호_비정상입력_숫자범위() {
        assertThatThrownBy(() -> new LottoDrawing("1,2,3,4,5,50", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_RANGE);
    }

    @Test
    void 당첨번호_비정상입력_숫자x() {
        assertThatThrownBy(() -> new LottoDrawing("1,2,3,4,5,a", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_NUMBER);
    }
    @Test
    void 당첨번호_비정상입력_중복() {
        assertThatThrownBy(() -> new LottoDrawing("1,2,3,4,5,5", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_DUPLICATE);
    }

    @Test
    void 보너스번호_비정상입력_숫자범위() {
        assertThatThrownBy(() -> new LottoDrawing("1,2,3,4,5,6", "50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_RANGE);
    }

    @Test
    void 보너스번호_비정상입력_숫자x() {
        assertThatThrownBy(() -> new LottoDrawing("1,2,3,4,5,6", "a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_NUMBER);
    }

}