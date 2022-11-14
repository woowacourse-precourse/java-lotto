package lotto.view;

import lotto.domain.constant.GuideMessage;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.LottoNum;
import lotto.domain.model.WinningNumber;
import lotto.domain.io.InputReader;

import java.util.List;

public class InputView {

  private InputReader inputReader;

  public InputView() {
    inputReader = new InputReader();
  }

  public LottoNum readPurchaseAmount() {
    System.out.println(GuideMessage.INPUT_MONEY.getMessage());
    return inputReader.readLottoNum();
  }
}
