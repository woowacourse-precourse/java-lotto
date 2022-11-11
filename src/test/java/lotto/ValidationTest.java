package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    void validateLottoNumber_메서드_사용시_숫자_입력이_아닐_경우_예외_발생() {
        String inputWithAlphabet = "abc";
        String inputWithKorean = "한글";

        assertAll(
                () -> assertThatThrownBy(() -> Input.validateLottoNumber(inputWithAlphabet))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Input.validateLottoNumber(inputWithKorean))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
