package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoNumber {
  List<Integer> numbers;

  public RandomLottoNumber() {
    setRandomNumber();
  }

  private void setRandomNumber() {
    numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
  }

  public List<Integer> getRandomNumber() {
    return numbers;
  }
}