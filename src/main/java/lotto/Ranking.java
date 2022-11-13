package lotto;

public enum Ranking {
  FIRST(6, 2000000000, false),
  SECOND(5, 30000000, true),
  THIRD(5, 1500000, false),
  FORTH(4, 50000, false),
  FIFTH(3, 5000, false);

  private final int number;
  private final int money;
  private final boolean hasBonus;

  Ranking(int number, int money, boolean hasBonus) {
    this.number = number;
    this.money = money;
    this.hasBonus = hasBonus;
  }

  public int getNumber(){
    return number;
  }

  public int getMoney() {
    return money;
  }

  public boolean isHasBonus() {
    return hasBonus;
  }

}
