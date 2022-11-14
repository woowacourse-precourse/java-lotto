package lotto;

public class Money {

  private final int money;

  public Money(int money) {
    validate(money);
    this.money = money;
  }

  public void validate(int money) {
    validateMinimum(money);
    validateDevided(money);
  }

  public void validateMinimum(int money) {
    if (money < 1000) {
      throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
    }
  }

  public void validateDevided(int money) {
    if (money % 1000 != 0) {
      throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
    }
  }

}
