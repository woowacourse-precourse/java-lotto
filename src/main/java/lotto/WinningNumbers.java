package lotto;

import java.util.HashSet;

public class WinningNumbers {

  public static final String DUPLICATED_INPUT_WINNING_NUMBER_ERROR = "[ERROR] 당첨 번호에는 중복 숫자가 없어야 합니다.";
  public static final String DUPLICATED_INPUT_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
  public static final String OUT_OF_RANGE_INPUT_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

  private final Lotto winningNumber;
  private final int bonusNumber;


  public WinningNumbers(Lotto winningNumber, int bonusNumber) {
    validate(winningNumber, bonusNumber);
    this.winningNumber = winningNumber;
    this.bonusNumber = bonusNumber;
  }

  public Lotto getWinningNumber() {
    return winningNumber;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }

  public void validate(Lotto winningNumber, int bonusNumber) {
    isDuplicatedWinningNum(winningNumber);
    isDuplicatedBonusNum(winningNumber, bonusNumber);
    for (int number: winningNumber.getNumbers()) {
      isBetween(number);
    }
    isBetween(bonusNumber);
  }

  public void isDuplicatedWinningNum(Lotto winningNumber) {
    if (new HashSet<>(winningNumber.getNumbers()).size() != winningNumber.getNumbers().size()) {
      throw new IllegalArgumentException(DUPLICATED_INPUT_WINNING_NUMBER_ERROR);
    }
  }

  public void isDuplicatedBonusNum(Lotto winningNumber, int bonusNumber) {
    if (winningNumber.getNumbers().contains(bonusNumber)) {
      throw new IllegalArgumentException(DUPLICATED_INPUT_BONUS_NUMBER_ERROR);
    }
  }

  public void isBetween(int number) {
    if (number < 1 || number > 45) {
      throw new IllegalArgumentException(OUT_OF_RANGE_INPUT_ERROR);
    }
  }

}
