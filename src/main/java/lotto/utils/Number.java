package lotto.utils;


public class Number {

  public static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

  public static void validateRange(Integer number) {
    if(number < 1 || number > 45) {
      throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
    }
  }
}
