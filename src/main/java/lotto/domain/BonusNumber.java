package lotto.domain;

import lotto.domain.io.NumberValidator;
import lotto.domain.io.RangeValidator;

public class BonusNumber {

  private final int bonusNum;

  public BonusNumber(String bonusNum) {
    this.bonusNum = validate(bonusNum);
  }

  private int validate(String bonusNum) {
    NumberValidator numberValidator = new NumberValidator();
    RangeValidator rangeValidator = new RangeValidator();

    int input = numberValidator.validate(bonusNum);
    rangeValidator.validate(input);
    return input;
  }
}
