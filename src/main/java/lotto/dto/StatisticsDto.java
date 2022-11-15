package lotto.dto;

public class StatisticsDto {
  private final int same3Num;
  private final int same4Num;
  private final int same5Num;
  private final int same5AndBonusNum;
  private final int same6Num;

  public StatisticsDto(int same3Num, int same4Num, int same5Num, int same5AndBonusNum, int same6Num) {
    this.same3Num = same3Num;
    this.same4Num = same4Num;
    this.same5Num = same5Num;
    this.same5AndBonusNum = same5AndBonusNum;
    this.same6Num = same6Num;
  }

  public int getSame3Num(){
    return same3Num;
  }
  public int getSame4Num(){
    return same4Num;
  }
  public int getSame5Num(){
    return same5Num;
  }
  public int getSame5AndBonusNum(){
    return same5AndBonusNum;
  }
  public int getSame6Num(){
    return same6Num;
  }
}
