package lotto.domain.machine;

import static lotto.domain.lotto.LottoNumbers.createDistinctLottoNumbers;
import static lotto.domain.result.LottoResult.makeStringResultOfEveryLottoList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;
import lotto.domain.utils.Input;

public class Machine {
  private final Integer count;
  private final List<List<Integer>> numbers = new ArrayList<>();
  public static final String OUTPUT_MESSAGE_OF_LOTTO_TICKETS = "%d개를 구매했습니다.\n";


  public Machine(final Integer count) {
    this.count = count;
    printTicketCount();
  }

  public void printTicketCount() {
    Input.emptyBuffer();
    System.out.printf(OUTPUT_MESSAGE_OF_LOTTO_TICKETS, count);
  }

  private void generateLottoNumberListByCount() {
    for(int count : countList()) {
      List<Integer> autoNumberList = new Lotto(createDistinctLottoNumbers()).getNumberList();
      numbers.add(autoNumberList);
    }
  }

  private List<Integer> countList() {
    return IntStream.range(0, count).boxed().collect(Collectors.toList());
  }

  public void printEveryLottoNumberList() {
    String result = makeStringResultOfEveryLottoList(numbers);
    System.out.println(result);
  }
}
