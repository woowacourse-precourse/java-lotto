package lotto;

import static lotto.Cli.inputPurchaseAmount;
import static lotto.Cli.print;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Machine class to manipulate lotto ticket. */
public class Machine {

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
}
