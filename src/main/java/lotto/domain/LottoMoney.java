package lotto.domain;

public class LottoMoney {

  private int money;
  private int lottoTicketCount;
  private static int MONEY_UNIT = 1000;
  
  public LottoMoney(int money) {
    validateMoney(money);
    this.money = money;
  }

  public int getMoney() {
    return this.money;
  }

  public void calculateLottoTicketCount() {
    try {
      this.lottoTicketCount = money / MONEY_UNIT;
      System.out.println("LottoMoney.calculateLottiTicketCount(): " + lottoTicketCount);
    } catch (Exception e) {
      throw new IllegalArgumentException("[ERROR] calculateLottoTicketCount");
    }
  }

  public int getLottoTicketCount() {
    return this.lottoTicketCount;
  }

  private void validateMoney(int money) {
    if (isLessThanMoneyUnit(money)) {
      throw new IllegalArgumentException("[ERROR] 입력한 로또 구입 금액이 1,000원 미만입니다.");
    } else if (!isDivideByMoneyUnit(money)) {
      throw new IllegalArgumentException("[ERROR] 입력한 로또 구입 금액이 1,000원 단위가 아닙니다.");
    }
  }

  private Boolean isLessThanMoneyUnit(int money) {
    if (money < MONEY_UNIT) {
      return true;
    }
    return false;
  }

  private Boolean isDivideByMoneyUnit(int money) {
    if (money % MONEY_UNIT == 0) {
      return true;
    }
    return false;
  }
}
