package lotto.domain.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.LottoNum;
import lotto.domain.model.WinningNumber;

import java.util.List;

public class InputReader {

  public LottoNum readLottoNum() {
    String input = Console.readLine();
    return new LottoNum(input);
  }

  public WinningNumber readWinningNumber() {
    String input = Console.readLine();
    CommaAndNumberValidator commaAndNumberValidator = new CommaAndNumberValidator();
    List<Integer> inputs = commaAndNumberValidator.validate(input);
    return new WinningNumber(inputs);
  }

  public BonusNumber readBonusNumber(WinningNumber winningNumber) {
    String input = Console.readLine();
    return new BonusNumber(winningNumber, input);
  }
}
