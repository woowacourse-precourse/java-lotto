package lotto;

public class Calculate {

  private Float calculateEarning(int[] ranking, int lottoTicket){
    return  100*((Grade.FIRST.getReward()*ranking[1])+
        (Grade.SECOND.getReward()*ranking[2])+
        (Grade.THIRD.getReward()*ranking[3])+
        (Grade.FOURTH.getReward()*ranking[4])+
        (Grade.FIFTH.getReward()*ranking[5]))/
        ((float) Math.max(1, lottoTicket) * 1000);
  }
}