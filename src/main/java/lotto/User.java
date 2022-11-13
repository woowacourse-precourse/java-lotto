package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
  private int ticket;
  private int money;
  private List<Lotto> lottos;
  private LottoWinRank win_rank;

  public User() {
    setTicket();
  }

  private void setTicket() {
//    int money;

    System.out.println("구입금액을 입력해 주세요.");
    money = Integer.parseInt(readLine());
    ticket = MathUtils.numberOfLotto(money);
  }

  public void setLottos() {
    System.out.println(ticket + "개를 구매했습니다.");
    for (int i = 0; i < ticket; i++) {
      RandomLottoNumber randomLottoNumber = new RandomLottoNumber();
      lottos.add(new Lotto(randomLottoNumber.getRandomNumber()));
      lottos.get(i).printLottoNumbers();
    }
  }



  public void printResult(LottoAnswer lottoAnswer) {
    win_rank = new LottoWinRank(lottos, lottoAnswer);
    win_rank.printWinRank();
    System.out.println("총 수익률은 " + MathUtils.calcYield(win_rank.calcWinMoney(), money) + "%입니다.");
  }

}
