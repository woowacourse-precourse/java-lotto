package lotto.domain.io;

import lotto.domain.constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommaAndNumberValidator {

  List<Integer> validate(String input) {
    List<String> inputList = new ArrayList<>(Arrays.asList(input.split(",")));
    List<Integer> digits;
    try {
      digits = inputList.stream().map(Integer::parseInt).collect(Collectors.toList());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ExceptionMessage.INPUT_IS_NOT_SEPARATED_BY_COMMAS.getMessage());
    }
    return digits;
  }
}