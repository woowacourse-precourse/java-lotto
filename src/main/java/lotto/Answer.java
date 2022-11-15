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

  public void setWinningLotto(Lotto winningLotto) {
    this.winningLotto = winningLotto;
  }

  public void setBonusNumber(Integer bonusNumber) {
    this.bonusNumber = bonusNumber;
  }
}
