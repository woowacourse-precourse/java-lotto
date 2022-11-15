package lotto.constant;

public enum LottoPrice {

  LOTTO_PRICE(1000);

  private final Integer price;

  LottoPrice(Integer price) {
    this.price = price;
  }

  public Integer getPrice() {
    return price;
  }
}
