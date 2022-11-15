package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class DuplicationValidatorTest {

  @ParameterizedTest
  @MethodSource("provideNormalInput")
  void 입력받은_당첨_번호에_중복되는_수가_없는_정상_작동_테스트(List<Integer> input) {
    DuplicationValidator duplicationValidator = new DuplicationValidator();
    assertThatCode(() -> duplicationValidator.validate(input))
      .doesNotThrowAnyException();
  }

  static Stream<Arguments> provideNormalInput() {
    return Stream.of(
      Arguments.of(List.of(1,2,3,4,5,6)),
      Arguments.of(List.of(45,46,47,48,49,50)),
      Arguments.of(List.of(-1,-2,-3,-4,-5,-6))
    );
  }

  @ParameterizedTest
  @MethodSource("provideExceptionInput")
  void 입력받은_당첨_번호에_중복되는_수가_포함되는_예외_처리_테스트(List<Integer> input) {
    DuplicationValidator duplicationValidator = new DuplicationValidator();
    assertThatThrownBy(() -> duplicationValidator.validate(input))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.INPUT_IS_DUPLICATED.getMessage());
  }

  static Stream<Arguments> provideExceptionInput() {
    return Stream.of(
      Arguments.of(List.of(1,1,1,1,1,1)),
      Arguments.of(List.of(1,2,1,3,4,5)),
      Arguments.of(List.of(46,46,47,48,49,50,51,52,53))
    );
  }

  @ParameterizedTest
  @MethodSource("provideNormalWinningNumberAndBonusNumber")
  void 입력받은_보너스_번호와_당첨_번호_간에_중복되는_수가_없는_정상_작동_테스트(List<Integer> winningNumber, int bonusNumber) {
    DuplicationValidator duplicationValidator = new DuplicationValidator();
    assertThatCode(() -> duplicationValidator.validate(winningNumber, bonusNumber))
      .doesNotThrowAnyException();
  }

  static Stream<Arguments> provideNormalWinningNumberAndBonusNumber() {
    return Stream.of(
      Arguments.of(List.of(1,2,3,4,5,6), 7),
      Arguments.of(List.of(45,46,47,48,49,50), 51),
      Arguments.of(List.of(-1,-2,-3,-4,-5,-6), -7)
    );
  }

  @ParameterizedTest
  @MethodSource("provideExceptionWinningNumberAndBonusNumber")
  void 입력받은_보너스_번호와_당첨_번호_간에_중복되는_수가_포함되는_예외_처리_테스트(List<Integer> winningNumber, int bonusNumber) {
    DuplicationValidator duplicationValidator = new DuplicationValidator();
    assertThatThrownBy(() -> duplicationValidator.validate(winningNumber, bonusNumber))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.INPUT_IS_DUPLICATED.getMessage());
  }

  static Stream<Arguments> provideExceptionWinningNumberAndBonusNumber() {
    return Stream.of(
      Arguments.of(List.of(1,1,1,1,1,1), 1),
      Arguments.of(List.of(1,2,1,3,4,5), 5),
      Arguments.of(List.of(46,46,47,48,49,50,51,52,53), 49)
    );
  }
}