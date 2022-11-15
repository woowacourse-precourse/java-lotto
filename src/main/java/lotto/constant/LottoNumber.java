package lotto.constant;

public enum LottoNumber {

  LOTTO_NUMBER(1, 45, 6);

  private Integer startInclusive;
  private Integer endInclusive;
  private Integer count;

  LottoNumber(final Integer startInclusive, final Integer endInclusive, final Integer count) {
    this.startInclusive = startInclusive;
    this.endInclusive = endInclusive;
    this.count = count;
  }

  public Integer getStart() {
    return startInclusive;
  }

  public Integer getEnd() {
    return endInclusive;
  }

  public Integer getCount() {
    return count;
  }
}
