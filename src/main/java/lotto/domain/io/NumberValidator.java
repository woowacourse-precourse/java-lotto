package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;

import java.util.NoSuchElementException;

public class NumberValidator {
  public int validate(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ExceptionMessage.INPUT_IS_NOT_NUMBER.getMessage());
    }

  }
}