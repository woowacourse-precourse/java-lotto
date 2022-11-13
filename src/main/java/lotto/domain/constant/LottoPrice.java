package lotto.domain.constant;

public enum LottoPrice {
  LOTTO_PRICE(1000);

  private int value;

  LottoPrice(int value) {
    this.value = value;
  }

  public int getLottoPrice() { return value; }
}
