package lotto.domain.utils;


import lotto.domain.lotto.Lotto;

public class Number {

  public static final String ERROR_MESSAGE_OF_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

  public static void validateRange(final Integer number) {
    if(number < Lotto.firstLottoNumber() || number > Lotto.lastLottoNumber()) {
      throw new IllegalArgumentException(ERROR_MESSAGE_OF_NUMBER_RANGE);
    }
  }
}
