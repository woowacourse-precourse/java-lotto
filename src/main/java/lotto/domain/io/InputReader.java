package lotto.domain.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputReader {

  private CommaAndNumberValidator commaAndNumberValidator;
  private NumberLengthValidator numberLengthValidator;
  private RangeValidator rangeValidator;
  private DuplicationValidator duplicationValidator;
  private NumberValidator numberValidator;
  private Multiple1000Validator multiple1000Validator;

  public InputReader() {
    this.commaAndNumberValidator = new CommaAndNumberValidator();
    this.numberLengthValidator = new NumberLengthValidator();
    this.rangeValidator = new RangeValidator();
    this.duplicationValidator = new DuplicationValidator();
    this.numberValidator = new NumberValidator();
    this.multiple1000Validator = new Multiple1000Validator();
  }

  public int readLottoPurchaseAmount() {
    String input = Console.readLine();
    int inputToInt = numberValidator.validate(input);
    multiple1000Validator.validate(inputToInt);
    return inputToInt;
  }
}
