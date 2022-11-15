package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {
    @Test
    void 숫자가_아닌_입력() {
        assertThatThrownBy(() -> new LottoController().validate("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천원단위가_아닌_입력() {
        assertThatThrownBy(() -> new LottoController().validate("1999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 양식(){
        assertThatThrownBy(() -> new LottoController().inputValueVerificate("1234567"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}