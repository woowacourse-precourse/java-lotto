package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ErrorTest {
    @DisplayName("ERROR 메시지 출력 성공")
    @Test
    void printErrorMessageByToString() {
        Error error = Error.INVALID_LOTTO_SIZE;
        String result = error.toString();

        assertThat(result).isEqualTo("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
    }
}
