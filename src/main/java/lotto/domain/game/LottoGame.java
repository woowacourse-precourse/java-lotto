package lotto.domain.game;

import lotto.constant.LottoRank;
import lotto.domain.lotto.LottoBonusNumber;
import lotto.domain.lotto.LottoWinningNumbers;
import lotto.domain.machine.Machine;
import lotto.domain.money.Money;
import lotto.domain.score.LottoScore;
import lotto.domain.score.LottoStatistics;
import lotto.domain.user.User;

public class LottoGame {
  public LottoGame() {

    User user = new User();
    Integer ticketCount = user.getTicketCount();

    Machine machine = new Machine(ticketCount);
    machine.generateLottoNumberListByCount();
    machine.printEveryLottoNumberList();

    LottoWinningNumbers numbers = new LottoWinningNumbers();


    LottoBonusNumber bonus = new LottoBonusNumber();
    LottoScore score = new LottoScore(numbers.getWinningNumbers(), bonus.getBonusNumber());
    LottoStatistics cal = new LottoStatistics();
    Money money = new Money();
    for(int i = 0; i < ticketCount; i++) {
      LottoRank rank = score.CompareMatchingRank(machine.getNumbers().get(i));
      cal.set(rank);
      money.setMoney(money.getMoney() + rank.price());
    }

    cal.printLottoStatisticMessage();
    Double rate = money.calculateTotalRate(ticketCount * 1000L);
    cal.printRevenuePercentageResult(rate);
  }
}
