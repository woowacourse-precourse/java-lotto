package lotto;

public enum Unit {
    MONEY_UNIT(1000),
    LOTTO_NUMBER_UNIT(6);

    final private Integer unit;

    Unit(int unit) {
      this.unit = unit;
    }

    public Integer getUnit() {
      return unit;
    }
}
