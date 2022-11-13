package lotto.domain.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoNum;

import java.util.List;

public class InputReader {

  public LottoNum readLottoNum() {
    String input = Console.readLine();
    return new LottoNum(input);
  }

  public Lotto readWinningNumber() {
    String input = Console.readLine();
    CommaAndNumberValidator commaAndNumberValidator = new CommaAndNumberValidator();
    List<Integer> inputs = commaAndNumberValidator.validate(input);
    return new Lotto(inputs);
  }

  public BonusNumber readBonusNumber() {
    String input = Console.readLine();
    return new BonusNumber(input);
  }
}
