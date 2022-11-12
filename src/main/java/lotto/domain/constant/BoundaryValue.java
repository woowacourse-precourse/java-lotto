package lotto.domain.constant;

public enum BoundaryValue {
  LOTTO_MIN_NUMBER(1),
  LOTTO_MAX_NUMBER(45);

  private int value;

  BoundaryValue(int value) {
    this.value = value;
  }
}
