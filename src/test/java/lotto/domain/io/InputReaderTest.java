package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;
import lotto.domain.model.LottoNum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

  @ParameterizedTest
  @CsvSource(value = {"1000, 1", "50000, 50", "8000, 8"})
  void 사용자의_입력을_받아_올바른_로또의_갯수를_계산하는가(String input, int num) {

    // given
    InputReader inputReader = new InputReader();
    InputStream inputStream = readUserInput(input);
    System.setIn(inputStream);

    // when
    LottoNum lottoNum = inputReader.readLottoNum();

    // then
    assertEquals(lottoNum.getLottoNum(), num);
  }

  @ParameterizedTest
  @MethodSource("provideExceptionInputAndExceptionMessage")
  void 잘못된_사용자의_입력에_각각_맞는_에러_메시지를_출력하는가(String input, String exceptionMessage) {
    InputReader inputReader = new InputReader();
    InputStream inputStream = readUserInput(input);
    System.setIn(inputStream);

    try {
      LottoNum lottoNum = inputReader.readLottoNum();
    } catch (IllegalArgumentException e) {
      assertEquals(exceptionMessage, e.getMessage());
    }
  }

  static Stream<Arguments> provideExceptionInputAndExceptionMessage() {
    return Stream.of(
      Arguments.of("1", ExceptionMessage.INPUT_IS_NOT_MULTIPLE_OF_1000.getMessage()),
      Arguments.of("999", ExceptionMessage.INPUT_IS_NOT_MULTIPLE_OF_1000.getMessage()),
      Arguments.of("1001", ExceptionMessage.INPUT_IS_NOT_MULTIPLE_OF_1000.getMessage()),
      Arguments.of("a", ExceptionMessage.INPUT_IS_NOT_NUMBER.getMessage())
    );
  }

  private InputStream readUserInput(String input) {
    return new ByteArrayInputStream(input.getBytes());
  }
}