package lotto.domain.model;

import lotto.domain.constant.LottoInfo;
import lotto.domain.io.*;

import java.util.Comparator;
import java.util.List;

public class WinningNumber {

  private final List<Integer> winningNumber;

  public WinningNumber(List<Integer> winningNumber) {
    this.winningNumber = validate(winningNumber);
  }

  private List<Integer> validate(List<Integer> winningNumber) {
    NumberLengthValidator numberLengthValidator = new NumberLengthValidator();
    RangeValidator rangeValidator = new RangeValidator();
    DuplicationValidator duplicationValidator = new DuplicationValidator();

    numberLengthValidator.validate(winningNumber);
    rangeValidator.validate(winningNumber);
    duplicationValidator.validate(winningNumber);
    return winningNumber;
  }

  public List<Integer> getWinningNumber() {
    return winningNumber;
  }
}
