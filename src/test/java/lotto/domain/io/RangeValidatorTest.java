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

class RangeValidatorTest {
  @ParameterizedTest
  @ValueSource(ints = {0,-1,46,0x7fffffff})
  void 입력값의_범위가_1부터_45사이가_아니라면_예외를_출력(int input) {
    RangeValidator rangeValidator = new RangeValidator();
    assertThatThrownBy(() -> rangeValidator.validate(input))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.INPUT_NUMBER_RANGE_IS_NOT_CORRECT.getMessage());
  }

  @ParameterizedTest
  @MethodSource("provideInput")
  void 로또_당첨_번호_입력값의_범위가_1부터_45사이가_아니라면_예외를_출력(List<Integer> input) {
    RangeValidator rangeValidator = new RangeValidator();
    assertThatThrownBy(() -> rangeValidator.validate(input))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.INPUT_NUMBER_RANGE_IS_NOT_CORRECT.getMessage());
  }

  static Stream<Arguments> provideInput() {
    return Stream.of(
      Arguments.of(List.of(0,1,2,3,4)),
      Arguments.of(List.of(-1,0,2,3,4,5,6,7)),
      Arguments.of(List.of(46,1,2,3,4,5,6))
    );
  }

}