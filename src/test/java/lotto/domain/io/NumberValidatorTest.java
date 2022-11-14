package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {
  @ParameterizedTest
  @ValueSource(strings = {"a", "", "(!(@", "111a", "1000j", "1.2.3"})
  void 입력값이_숫자가_아니라면_예외를_출력(String input) {
    NumberValidator numberValidator = new NumberValidator();
    assertThatThrownBy(() -> numberValidator.validate(input))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.INPUT_IS_NOT_NUMBER.getMessage());
  }

}