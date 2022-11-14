package lotto;

public enum Grade {
  FIFTH(30,5000, "3개 일치 (5,000원)"),
  FOURTH(40,50000,"4개 일치 (50,000원)"),
  THIRD(50,1500000,"5개 일치 (1,500,000원)"),
  SECOND(51,30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
  FIRST(60,2000000000,"6개 일치 (2,000,000,000원)");

  private int correctCount;
  private Integer reward;
  private String output;

  Grade(int correctCount, Integer reward, String output) {
    this.correctCount = correctCount;
    this.reward = reward;
    this.output = output;
  }

  public String getOutput() {
    return output;
  }

  public int getCorrectCount() {
    return correctCount;
  }

  public Integer getReward() {
    return reward;
  }
}
