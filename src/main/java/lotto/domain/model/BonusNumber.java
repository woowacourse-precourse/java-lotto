package lotto.domain.model;

import lotto.domain.io.DuplicationValidator;
import lotto.domain.io.NumberValidator;
import lotto.domain.io.RangeValidator;

public class BonusNumber {

  private final int bonusNum;

  public BonusNumber(WinningNumber winningNumber, String bonusNum) {
    this.bonusNum = validate(winningNumber, bonusNum);
  }

  private int validate(WinningNumber winningNumber, String bonusNum) {
    NumberValidator numberValidator = new NumberValidator();
    RangeValidator rangeValidator = new RangeValidator();
    DuplicationValidator duplicationValidator = new DuplicationValidator();

    int input = numberValidator.validate(bonusNum);
    rangeValidator.validate(input);
    duplicationValidator.validate(winningNumber.getWinningNumber(), input);
    return input;
  }

  public int getBonusNum() {
    return bonusNum;
  }
}
