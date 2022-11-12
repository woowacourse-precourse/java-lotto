package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;

import java.util.List;

public class DuplicationValidator {
  void validate(List<Integer> input){
    if (input.size() != input.stream().distinct().count()) {
      throw new IllegalArgumentException(ExceptionMessage.INPUT_IS_DUPLICATED.getMessage());
    }
  }
}
