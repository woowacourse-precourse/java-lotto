package lotto.domain;

import static lotto.response.Error.LOTTO_NUMBER_DUPLICATION_ERROR;

public class Answer {

  private final Lotto winningLotto;
  private final Integer bonusNumber;

  public Answer(Lotto winningLotto, Integer bonusNumber) {
    if (winningLotto.compare(bonusNumber)) {
      throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION_ERROR.toString());
    }
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
