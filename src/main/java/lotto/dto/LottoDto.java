package lotto.dto;

import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningNumber;

import java.util.List;

public class LottoDto {
  private List<Lotto> myLottos;
  private WinningNumber winningNumber;
  private BonusNumber bonusNumber;

  public LottoDto(List<Lotto> myLottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
    this.myLottos = myLottos;
    this.winningNumber = winningNumber;
    this.bonusNumber = bonusNumber;
  }

  public List<Lotto> getMyLottos() {
    return myLottos;
  }
  public WinningNumber getWinningNumber() {
    return winningNumber;
  }
  public BonusNumber getBonusNumber() {
    return bonusNumber;
  }
}
