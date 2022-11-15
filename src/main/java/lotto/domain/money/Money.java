package lotto.domain.money;

public class Money {

  private Long money = 0L;

  public void setMoney(Long amount) {
    money = amount;
  }

  public Long getMoney() {
    return money;
  }

  public Double calculateTotalRate(Long investmentMoney) {
    return Math.round(((double) this.money / investmentMoney ) * 100 * 10) / 10.0;
  }
}
