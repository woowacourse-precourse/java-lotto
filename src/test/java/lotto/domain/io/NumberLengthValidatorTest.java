package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberLengthValidatorTest {
  @ParameterizedTest
  @MethodSource("provideLotto")
  void 입력받은_로또_번호의_갯수가_6개가_아니라면_예외를_출력(List<Integer> lotto) {
    NumberLengthValidator numberLengthValidator = new NumberLengthValidator();
    assertThatThrownBy(() -> numberLengthValidator.validate(lotto))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.INPUT_IS_NOT_SIX_NUMBERS.getMessage());
  }

  static Stream<Arguments> provideLotto() {
    return Stream.of(
      Arguments.of(List.of(1,1,1,1,1,1,1)),
      Arguments.of(List.of()),
      Arguments.of(List.of(46,46,47,48,49,50,51,52,53))
    );
  }

}