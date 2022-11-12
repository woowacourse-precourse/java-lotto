package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;

import java.util.List;

public class RangeValidator {

  public void validate(List<Integer> input) {
    boolean isWithinRange = input.stream().allMatch(it -> it < 46 && it > 0);
    if (!isWithinRange) {
      throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_RANGE_IS_NOT_CORRECT.getMessage());
    }
  }


}
