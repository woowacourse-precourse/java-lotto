package lotto;

import static lotto.GameMessageManager.*;
import static lotto.InputUtil.*;

public class GameManager {
  private User user;
  private Lotto prizeLotto;
  private int bonusNumber;

  public GameManager() {
    this.user = new User();
  }

  public void lottoGameStart() {
    try {
      buyLotto();
      printBuyLottoList();
      prizeLotto = getPrizeNumberByUserInput();
      bonusNumber = getBonusNumberByUserInput();
      PrizeStatistics prizeStatistics = new PrizeStatistics(prizeLotto, bonusNumber);
      showPrizeStatistics(prizeStatistics);
      user.setPrizeMoney(prizeStatistics.calculatePrizeMoney());
      printShowReturnRateMessage(user.calculateReturnRate());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  private void buyLotto() {
    printInputBuyAmountMessage();
    user.setBuyAmount(getIntegerInput());
    user.setBuyCount();
    printBlankLine();
  }

  private void printBuyLottoList() {
    printBuyCount(user.getBuyCount());
    user.setUserLottoList(LottoGenerator.getRandomLottoListByCount(user.getBuyCount()));
    user.printUserLottoList();
    printBlankLine();
  }

  private Lotto getPrizeNumberByUserInput() {
    printInputPrizeNumberMessage();
    Lotto prizeLotto = getPrizeLotto();
    printBlankLine();
    return prizeLotto;
  }

  private int getBonusNumberByUserInput() {
    printInputBonusNumberMessage();
    int bonusNumber = getIntegerInput();
    LottoValidator.checkIsNumberInRange(bonusNumber);
    if (prizeLotto.isNumberContained(bonusNumber)) {
      throw new IllegalArgumentException("보너스 번호가 당첨번호와 중복됩니다!");
    }
    printBlankLine();
    return bonusNumber;
  }

  private void showPrizeStatistics(PrizeStatistics prizeStatistics) {
    prizeStatistics.setPrizeRankArrayByLottoList(user.getUserLottoList());
    printBlankLine();
    printShowPrizeStatisticsMessage();
    prizeStatistics.printPrizeStatistics();
  }
}
