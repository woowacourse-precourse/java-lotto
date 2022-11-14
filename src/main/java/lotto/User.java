package lotto;

import java.util.ArrayList;
import java.util.List;

import static Error.ErrorInput.isDigit;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
  private int ticket;
  private int money;
  private final List<Lotto> lottos = new ArrayList<>();

  public User() {
    setTicket();
  }

  private void setTicket() {
    System.out.println("구입금액을 입력해 주세요.");
    String money = readLine();
    if (!isDigit(money)) {
      System.out.println("[ERROR] 잘못된 입력입니다.");
//      throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
      return;
    }
    this.money = Integer.parseInt(money);
    ticket = MathUtils.numberOfLotto(this.money);
  }

  public void setLottos() {

    System.out.println(ticket + "개를 구매했습니다.");
      RandomLottoNumber randomLottoNumber;
    for (int i = 0; i < ticket; i++) {
      randomLottoNumber = new RandomLottoNumber();
      lottos.add(new Lotto(randomLottoNumber.getRandomNumber()));
      lottos.get(i).printLottoNumbers();
    }
    System.out.println();
  }

  public void printResult(LottoAnswer lottoAnswer) {
    LottoWinRank win_rank = new LottoWinRank(lottos, lottoAnswer);
    win_rank.printWinRank();
    System.out.println("총 수익률은 " + MathUtils.calcYield(win_rank.calcWinMoney(), money) + "%입니다.");
  }
}
