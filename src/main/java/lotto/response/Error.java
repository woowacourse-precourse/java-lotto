package lotto.response;

public enum Error {

  LOTTO_NUMBER_COUNT_ERROR("로또 번호의 개수는 6개여야 합니다."),
  LOTTO_NUMBER_DUPLICATION_ERROR("로또 번호는 중복된 값이 없어야 합니다."),
  LOTTO_NUMBER_OUT_OF_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
  LOTTO_PURCHASE_TYPE_ERROR("로또 구매금액은 숫자 자료형이어야 합니다."),
  LOTTO_PURCHASE_MONETARY_UNIT_ERROR("로또 구매금액은 1000원 단위여야 합니다.");

  private final String message;

  Error(String message) {
    String PREFIX = "[ERROR]";
    this.message = PREFIX + " " + message;

  }

  @Override
  public String toString() {
    return this.message;
  }
}
