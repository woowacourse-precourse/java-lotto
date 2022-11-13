package lotto;

import java.util.ArrayList;
import java.util.Iterator;
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

  public ArrayList<Integer> getRandomNumber() {
    ArrayList<Integer> lotto_arr = new ArrayList<>();
    Iterator<Integer> iter = lotto.iterator();

    while (iter.hasNext()) {
      lotto_arr.add(iter.next());
    }

    return lotto_arr;
  }
}