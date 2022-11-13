package lotto.Validator;

import lotto.validator.LottoNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberValidatorTest {
    LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

    @DisplayName("당첨 번호에 중복된 값이 있다면 예외 처리한다.")
    @Test
    void validateTest1() {
        assertThatThrownBy(() -> lottoNumberValidator.validateDuplicateNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 길이가 6이 아니라면 예외 처리한다.")
    @Test
    void validateTest2() {
        assertThatThrownBy(() -> lottoNumberValidator.validateNumberSize(List.of(1, 2, 3, 4, 5, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1 이상 45미만 이외의 값을 갖는다면 예외 처리한다.")
    @Test
    void validateTest3() {
        assertThatThrownBy(() -> lottoNumberValidator.validateNumberRange(List.of(1, 2, 3, 4, 5, 51)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
