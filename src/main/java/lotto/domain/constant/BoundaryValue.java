package lotto.domain.constant;

public enum BoundaryValue {
  LOTTO_MIN_NUMBER(1),
  LOTTO_MAX_NUMBER(45),
  LOTTO_LESS_THAN_NUMBER(0),
  LOTTO_EXCEEDED_NUMBER(46);

  private int value;

  BoundaryValue(int value) {
    this.value = value;
  }

  public int getBoundaryValue() { return value; }
}
