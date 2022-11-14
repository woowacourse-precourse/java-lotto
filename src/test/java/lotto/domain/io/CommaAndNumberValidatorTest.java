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

/**
 * @ParameterizedTest
 *   @MethodSource("provideExpectedInputAndActualErrorMessage")
 *   void 플레이어가_입력한_3자리_숫자가_잘못된_값인_경우_특정_메시지를_포함한_예외를_던지는가(String input, String actualErrorMessage) {
 *     try {
 *       InputValidator validator = new PlayingInputValidator();
 *       String userInput = input;
 *       validator.validate(userInput);
 *     } catch (IllegalArgumentException e) {
 *       assertEquals(actualErrorMessage, e.getMessage());
 *     }
 *   }
 *
 *   static Stream<Arguments> provideExpectedInputAndActualErrorMessage() {
 *     return Stream.of(
 *       Arguments.of("112", ExceptionMessages.INPUT_IS_NOT_UNIQUE.getExceptionMessage()),
 *       Arguments.of("12", ExceptionMessages.INPUT_LENGTH_IS_NOT_THREE.getExceptionMessage()),
 *       Arguments.of("1234", ExceptionMessages.INPUT_LENGTH_IS_NOT_THREE.getExceptionMessage()),
 *       Arguments.of("120", ExceptionMessages.INPUT_IS_NOT_DIGIT.getExceptionMessage()),
 *       Arguments.of("가나다", ExceptionMessages.INPUT_IS_NOT_DIGIT.getExceptionMessage())
 *     );
 *   }
 */