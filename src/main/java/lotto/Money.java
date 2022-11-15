package lotto;

public class Money {

  private final int money;
  private int numOfLotto;

  public Money(int money) {
    validate(money);
    this.money = money;
    setNumOfLotto();
  }

  public int getMoney() {
    return money;
  }

  public void validate(int money) {
    validateMinimum(money);
    validateDivided(money);
  }

  public void setNumOfLotto() {
    numOfLotto = money / 1000;
  }

  public int getNumOfLotto() {
    return numOfLotto;
  }

  public void validateMinimum(int money) {
    if (money < 1000) {
      throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
    }
  }

  public void validateDivided(int money) {
    if (money % 1000 != 0) {
      throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
    }
  }

}

