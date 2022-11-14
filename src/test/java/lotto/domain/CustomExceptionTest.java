package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ExceptionEnum 테스트")
class CustomExceptionTest {

    @DisplayName("RANGE 테스트")
    @Test
    void rangeTest() {
        CustomException range = CustomException.RANGE;
        String rangeMessage = range.getMessage();
        assertThat(rangeMessage).isEqualTo("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("VALIDATE 테스트")
    @Test
    void validateTest() {
        CustomException validate = CustomException.VALIDATE;
        String validateMessage = validate.getMessage();
        assertThat(validateMessage).isEqualTo("[ERROR] 로또 번호를 6개 입력해주세요.");
    }

    @DisplayName("DUPLICATE 테스트")
    @Test
    void duplicateTest() {
        CustomException duplicate = CustomException.DUPLICATE;
        String duplicateMessage = duplicate.getMessage();
        assertThat(duplicateMessage).isEqualTo("[ERROR] 중복된 로또 번호가 있습니다.");
    }
}