package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;

public class ZeroAndMinusValidator {
  public void validate(int input) {
    if (input < 1) {
      throw new IllegalArgumentException(ExceptionMessage.INPUT_IS_ZERO_OR_MINUS.getMessage());
    }
  }
}
