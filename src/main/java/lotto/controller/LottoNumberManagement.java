package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberManagement {
  private final int LOTTO_START_NUMBER = 1;
  private final int LOTTO_END_NUMBER = 45;
  private final int LOTTO_NUMBERS_SIZE = 6;

  private List<Integer> numbers;

  public LottoNumberManagement() {
    numbers = new ArrayList<>();
  }

  public List<Integer> generateRandomNumbers() {
    numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBERS_SIZE);
    return numbers;
  }
  private List<Integer> sortNumbers(List<Integer> numbers) {
    Collections.sort(numbers);
    return numbers;
  }
}
