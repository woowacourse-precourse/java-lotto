package lotto.controller;

import lotto.Lotto;
import lotto.LottoPirnt;
import lotto.UserNumberScan;
import lotto.message.Message;
import lotto.money.Money;
import lotto.numbers.BonusNumber;
import lotto.numbers.MatchNumbers;
import lotto.numbers.RandomNumberCreater;
import lotto.numbers.WinningNumber;

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
