package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.Message.ERROR_MESSAGE;
import static lotto.constant.Message.INVALID_NUMBER_INPUT_FORMAT_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLottoTest {
    @Test
    void 보너스_번호_숫자_아닐_시_예외_처리() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), "a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_중복_시_예외_처리() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_중복_시_예외_처리() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 1, 2, 3, 4, 5), "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력_시_범위_미만_초과_시_예외_처리() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new WinningLotto(List.of(0, 1, 2, 3, 4, 46), "6"));

        assertEquals(exception.getMessage(), ERROR_MESSAGE + INVALID_NUMBER_INPUT_FORMAT_MESSAGE);
    }
}
