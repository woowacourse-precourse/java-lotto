package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;

public class NumberValidator {
  int validate(String input) {
    int inputToInt;
    try {
      inputToInt = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ExceptionMessage.INPUT_IS_NOT_NUMBER.getMessage());
    }
    return inputToInt;
  }
}