package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;

import java.util.List;

public class NumberLengthValidator {
  void validate(List<Integer> input){
    if (input.size() != 6) {
      throw new IllegalArgumentException(ExceptionMessage.INPUT_IS_NOT_SIX_NUMBERS.getMessage());
    }
    RangeValidator validator = new RangeValidator();
    validator.validate(input);
  }
}
