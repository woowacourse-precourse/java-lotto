package lotto.constant;

public enum LottoPrice {

  LOTTO_PRICE(1000L);

  private final Long price;

  LottoPrice(Long price) {
    this.price = price;
  }

  public Long getPrice() {
    return price;
  }
}
