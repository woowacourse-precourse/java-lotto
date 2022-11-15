package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Machine class for creating lotto ticket and calculate winning of the lotto. */
public class Machine {

  /**
   * Function to create lotto.
   * @param count The integer value of lotto count.
   * @return The list of lotto.
   */
  public static List<Lotto> createLotto(Integer count) {

    List<Lotto> lottoList = new ArrayList<>();
    for (int i=0; i < count; i++) {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      List<Integer> sortedNumber = numbers.stream()
          .sorted().collect(Collectors.toList());
      Lotto lotto = new Lotto(sortedNumber);
      lottoList.add(lotto);
    }

    return lottoList;
  }
}
