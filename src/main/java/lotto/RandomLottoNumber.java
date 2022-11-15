package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constantValue.ErrorMessage.IS_NOT_IN_RANGE;
import static constantValue.LottoUtilNumber.*;
import static error.ErrorLottoNumbers.isOutBoundNumbers;

public class RandomLottoNumber {
  ArrayList<Integer> numbers;

  public RandomLottoNumber() {
    setRandomNumber();
  }

  private void setRandomNumber() {
    List<Integer> random_numbers;
    random_numbers = Randoms.pickUniqueNumbersInRange(UNDER_RANGE, OVER_RANGE, LOTTO_SIZE);
    if (isOutBoundNumbers(random_numbers)) {
      throw new IllegalArgumentException(IS_NOT_IN_RANGE);
    }
    numbers = new ArrayList<>(random_numbers);
    Collections.sort(numbers);
  }

  public List<Integer> getRandomNumber() {
    return numbers;
  }

}