package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ErrorResponseTest {

    @Test
    void BAD_INPUT_STRING_예외반환_성공() throws Exception {
        assertThatThrownBy(() -> {
            throw ErrorResponse.BAD_INPUT_STRING.exception();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void DUPLICATED_LOTTO_NUMBER_예외반환_성공() throws Exception {
        assertThatThrownBy(() -> {
            throw ErrorResponse.DUPLICATED_LOTTO_NUMBER.exception();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void BAD_LENGTH_LOTTO_NUMBERS_예외반환_성공() throws Exception {
        assertThatThrownBy(() -> {
            throw ErrorResponse.BAD_LENGTH_LOTTO_NUMBERS.exception();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void BAD_RANGE_LOTTO_NUMBERS_예외반환_성공() throws Exception {
        assertThatThrownBy(() -> {
            throw ErrorResponse.BAD_RANGE_LOTTO_NUMBERS.exception();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void BAD_BONUS_LOTTO_NUMBER_예외반환_성공() throws Exception {
        assertThatThrownBy(() -> {
            throw ErrorResponse.BAD_BONUS_LOTTO_NUMBER.exception();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}