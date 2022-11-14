package lotto;

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
    isDuplicated(winningNumber, bonusNumber);
    for (int number: winningNumber.getNumbers()) {
      isBetween(number);
    }
  }

  public void isDuplicated(Lotto winningNumber, int bonusNumber) {
    if (winningNumber.getNumbers().contains(bonusNumber)) {
      throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
  }

  public void isBetween(int number) {
    if (number < 1 || number > 45) {
      throw new IllegalArgumentException("로또 번호는 1~45 내에 있어야 합니다.");
    }
  }

}
