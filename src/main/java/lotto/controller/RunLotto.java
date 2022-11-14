package lotto.controller;

import lotto.Lotto;
import lotto.view.LottoPirnt;
import lotto.domain.UserNumberScan;
import lotto.view.Message;
import lotto.domain.Money;
import lotto.domain.BonusNumber;
import lotto.domain.MatchNumbers;
import lotto.domain.RandomNumberCreater;
import lotto.domain.WinningNumber;

import java.util.List;

public class RunLotto {
  public  void test1() {
    // TODO: 프로그램 구현
    Message.requestInputMoneyMessage();
    Money.countLotto(UserNumberScan.requestValue());
    Message.lottoBuyMessage(Money.count);
    List<Lotto> countLotto = RandomNumberCreater.generateLottoNumber(Money.count);
    LottoPirnt.printPaper(countLotto);
    Message.requestWinningNumberMessage();

    WinningNumber winningNumber = new WinningNumber(UserNumberScan.requestValue());
    List<Integer> numbers = winningNumber.getNumber();

    Message.requestBonusNumberMessage();

    int validBonusNumber = BonusNumber.validBonusNumber(UserNumberScan.requestValue(), numbers);
    MatchNumbers matchNumbers = new MatchNumbers();

    matchNumbers.match(countLotto, numbers, validBonusNumber);
    Message.matchMessage(matchNumbers.getMaps());
    Message.ratio(Money.percentage(matchNumbers.getMaps()));
  }
}
