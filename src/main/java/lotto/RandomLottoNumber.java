package lotto;

import java.util.TreeSet;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomLottoNumber {
  TreeSet<Integer> lotto = new TreeSet<>();

  public RandomLottoNumber() {
    setRandomNumber();
  }

  private void setRandomNumber() {

    for (int i = 0; i < 6; i++) {
      if (lotto.add(pickNumberInRange(1, 45))) {
        i--;
        continue;
      }
    }
  }

  public TreeSet<Integer> getRandomNumber() {
    return lotto;
  }

}