package lotto.domain.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;

public class InputReader {

  private CommaAndNumberValidator commaAndNumberValidator;
  private RangeValidator rangeValidator;
  private NumberValidator numberValidator;
  private Multiple1000Validator multiple1000Validator;

  public InputReader() {
    this.commaAndNumberValidator = new CommaAndNumberValidator();
    this.rangeValidator = new RangeValidator();
    this.numberValidator = new NumberValidator();
    this.multiple1000Validator = new Multiple1000Validator();
  }

  public int readLottoPurchaseAmount() {
    String input = Console.readLine();
    int inputToInt = numberValidator.validate(input);
    multiple1000Validator.validate(inputToInt);
    return inputToInt;
  }

  public Lotto readWinningNumber() {
    String input = Console.readLine();
    List<Integer> inputs = commaAndNumberValidator.validate(input);
    return new Lotto(inputs);
  }

  public int readBonusNumber() {
    String input = Console.readLine();
    int inputToInt = numberValidator.validate(input);
    rangeValidator.validate(inputToInt);
    return inputToInt;
  }
}
