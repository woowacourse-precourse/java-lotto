package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;

public class NumberValidator {
  void validate(String input) {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ExceptionMessage.INPUT_IS_NOT_NUMBER.getMessage());
    }
  }
}