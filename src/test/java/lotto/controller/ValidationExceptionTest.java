package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidationExceptionTest {

    @Test
    @DisplayName("1,000원 단위 체크")
    void correctInput() {
        assertThat(ValidationException.checkValidPrice("22000")).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("1,000원 단위가 아닐 시 에러 발생")
    @ValueSource(strings = {"12345", "가나다", "", "1200","000"})
    void incorrectInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> ValidationException.checkValidPrice(input));
    }

}