package lotto;

public class Answer {

  private Lotto winningLotto;
  private Integer bonusNumber;

  public Answer(Lotto winningLotto, Integer bonusNumber) {
    this.winningLotto = winningLotto;
    this.bonusNumber = bonusNumber;
  }

  public Lotto getWinningLotto() {
    return winningLotto;
  }

  public Integer getBonusNumber() {
    return bonusNumber;
  }
}
