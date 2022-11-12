package lotto.domain.io;

import lotto.domain.constant.BoundaryValue;
import lotto.domain.constant.ExceptionMessage;

import java.util.List;

public class RangeValidator {

  void validate(int input) {
    if (input < BoundaryValue.LOTTO_MIN_NUMBER.getBoundaryValue() || input > BoundaryValue.LOTTO_MAX_NUMBER.getBoundaryValue()) {
      throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_RANGE_IS_NOT_CORRECT.getMessage());
    }
  }

  void validate(List<Integer> input) {
    boolean isWithinRange = input.stream().allMatch(it -> it < BoundaryValue.LOTTO_EXCEEDED_NUMBER.getBoundaryValue() && it > BoundaryValue.LOTTO_LESS_THAN_NUMBER.getBoundaryValue());
    if (!isWithinRange) {
      throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_RANGE_IS_NOT_CORRECT.getMessage());
    }
  }
}
