package lotto.domain;

public class Answer {

  private final Lotto winningLotto;
  private final Integer bonusNumber;

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
