package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("로또 숫자는 숫자만 입력 가능하다.")
    @Test
    void 로또_숫자는_숫자만_가능() {
        assertThrows(IllegalArgumentException.class, () ->
                new LottoNumber("n"));
    }

    @DisplayName("로또 숫자는 1 ~ 45 사이의 값만 입력 가능하다.")
    @Test
    void 로또_숫자는_1에서_45사이만_가능() {
        assertThrows(IllegalArgumentException.class, () ->
                new LottoNumber("50"));
    }

    @DisplayName("정상 값")
    @Test
    void 로또_숫자는_정상_생성() {
        assertDoesNotThrow(() -> new LottoNumber("45"));
    }
}