package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;

public class Multiple1000Validator {
  void validate(String input) {
    int inputToInt = Integer.parseInt(input);
    if (inputToInt % 1000 != 0) {
      throw new IllegalArgumentException(ExceptionMessage.INPUT_IS_NOT_MULTIPLE_OF_1000.getMessage())
    }
  }
}
