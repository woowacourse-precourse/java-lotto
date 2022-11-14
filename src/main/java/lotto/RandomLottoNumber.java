package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumber {
  ArrayList<Integer> numbers;

  public RandomLottoNumber() {
    setRandomNumber();
  }

  private void setRandomNumber() {
    List<Integer> random_numbers;
    random_numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    numbers = new ArrayList<>(random_numbers);
    Collections.sort(numbers);
  }

  public List<Integer> getRandomNumber() {
    return numbers;
  }

}