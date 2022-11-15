package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ZeroAndMinusValidatorTest {

  @ParameterizedTest
  @ValueSource(ints = {0,-1,-33333})
  void 입력값에_0_혹은_음수가_들어올경우_예외가_발생하는가(int input) {
    ZeroAndMinusValidator zeroAndMinusValidator = new ZeroAndMinusValidator();
    assertThatThrownBy(() -> zeroAndMinusValidator.validate(input))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.INPUT_IS_ZERO_OR_MINUS.getMessage());
  }
}