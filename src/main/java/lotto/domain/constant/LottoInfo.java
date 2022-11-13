package lotto.domain.constant;

public enum LottoInfo {
  LOTTO_PRICE(1000),
  LOTTO_LENGTH(6);

  private int value;

  LottoInfo(int value) {
    this.value = value;
  }

  public int getValue() { return value; }
}
