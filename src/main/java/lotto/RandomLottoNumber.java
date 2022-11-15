package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constantValue.LottoUtilNumber.*;

public class RandomLottoNumber {
  ArrayList<Integer> numbers;

  public RandomLottoNumber() {
    setRandomNumber();
  }

  private void setRandomNumber() {
    List<Integer> random_numbers;
    random_numbers = Randoms.pickUniqueNumbersInRange(UNDER_RANGE, OVER_RANGE, LOTTO_SIZE);
    numbers = new ArrayList<>(random_numbers);
    Collections.sort(numbers);
  }

  public List<Integer> getRandomNumber() {
    return numbers;
  }

}