package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class Multiple1000ValidatorTest {

  @ParameterizedTest
  @ValueSource(ints = {11111,999,100})
  void 입력값이_1000의_배수가_아닐때_예외를_던지는가(int input) {
    Multiple1000Validator multiple1000Validator = new Multiple1000Validator();
    assertThatThrownBy(() -> multiple1000Validator.validate(input))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.INPUT_IS_NOT_MULTIPLE_OF_1000.getMessage());
  }

}