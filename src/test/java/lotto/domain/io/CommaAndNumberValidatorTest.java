package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CommaAndNumberValidatorTest {

  @ParameterizedTest
  @ValueSource(strings = {"1,2,,3,4,5,6", " 1,2,3,4,5,6", "1,2, 3,4,5,6", "a,b,c,d,e,f", "a,1,2,3,4,5", "1.2.3.4.5.6"})
  void 입력값은_콤마를_구분자로한_숫자만_존재하는가(String input) {
    CommaAndNumberValidator commaAndNumberValidator = new CommaAndNumberValidator();
    assertThatThrownBy(() -> commaAndNumberValidator.validate(input))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.INPUT_IS_NOT_SEPARATED_BY_COMMAS.getMessage());
  }

}
