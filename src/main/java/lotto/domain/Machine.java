package lotto.domain;

import static lotto.Cli.inputBonusNumber;
import static lotto.Cli.inputPurchaseAmount;
import static lotto.Cli.inputWinningNumbers;
import static lotto.Cli.print;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Machine class to manipulate lotto ticket. */
public class Machine {

  private Answer answer;
  private final String[] resultMessage = {
    "3개 일치 (5,000원)",
    "4개 일치 (50,000원)",
    "5개 일치 (1,500,000원)",
    "5개 일치, 보너스 볼 일치 (30,000,000원)",
    "6개 일치 (2,000,000,000원)",
  };
  private final int[] prizeMoney = { 5000, 50000, 1500000, 30000000, 2000000000 };

  /**
   * Get money to return ticket count.
   * @return The count of ticket.
   */
  public Integer getMoney() {
    int amount = inputPurchaseAmount();
    return amount / 1000;
  }


  /**
   * Function to sell lotto tickets.
   * @param count The integer value of lotto count.
   * @return The list of lotto tickets.
   */
  public List<Lotto> sellTicket(Integer count) {

    List<Lotto> ticketList = new ArrayList<>();
    for (int i=0; i < count; i++) {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      List<Integer> sortedNumber = numbers.stream()
          .sorted().collect(Collectors.toList());
      Lotto lotto = new Lotto(sortedNumber);
      ticketList.add(lotto);
    }
    print(ticketList);
    return ticketList;
  }

  /**
   * Generate the answer from the user's input.
   */
  public void createAnswer() {

    List<Integer> winningNumbers = inputWinningNumbers();
    Lotto winningLotto = new Lotto(winningNumbers);
    int bonusNumber = inputBonusNumber();
    this.answer = new Answer(winningLotto, bonusNumber);
  }

  /**
   * Calculate rank of ticket.
   * @param ticketList The list of ticket.
   */
  public void printResult(List<Lotto> ticketList) {
    System.out.println("당첨 통계\n" + "---");

    int[] rank = calculateRank(ticketList);

    for(int i=0; i<5; i++) {
      System.out.println(resultMessage[i] + " - " + rank[i] + "개");
    }

    float profitRate = calculateProfitRate(rank, ticketList.size());
    System.out.println("총 수익률은 " + profitRate + "%입니다.");
  }

  private int[] calculateRank(List<Lotto> ticketList) {

    int[] rank = new int[5];
    Lotto winningLotto = answer.getWinningLotto();
    int bonusNumber = answer.getBonusNumber();

    for(Lotto ticket: ticketList) {
      int winningCount = ticket.compare(winningLotto);
      boolean isBonus = ticket.compare(bonusNumber);

      if (winningCount==3) {
        rank[0] += 1;
      }
      if (winningCount==4) {
        rank[1] += 1;
      }
      if (winningCount==5 && !isBonus) {
        rank[2] += 1;
      }
      if (winningCount==5 && isBonus) {
        rank[3] += 1;
      }
      if (winningCount==6) {
        rank[4] += 1;
      }
    }

    return rank;
  }

  private float calculateProfitRate(int[] rank, int count) {
    float principal = count * 1000;
    float profit = 0;

    for(int i=0; i<5; i++) {
      profit+=rank[i]*prizeMoney[i];
    }

    return profit/principal*100;
  }
}
