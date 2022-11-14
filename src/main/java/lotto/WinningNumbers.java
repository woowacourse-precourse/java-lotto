package lotto;

import java.util.HashSet;
import java.util.stream.Collectors;

public class WinningNumbers {

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
  }

  public void isDuplicatedWinningNum(Lotto winningNumber) {
    if (new HashSet<>(winningNumber.getNumbers()).size() != winningNumber.getNumbers().size()) {
      throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복 숫자가 없습니다.");
    }
  }

  public void isDuplicatedBonusNum(Lotto winningNumber, int bonusNumber) {
    if (winningNumber.getNumbers().contains(bonusNumber)) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
  }

  public void isBetween(int number) {
    if (number < 1 || number > 45) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 내에 있어야 합니다.");
    }
  }

}
