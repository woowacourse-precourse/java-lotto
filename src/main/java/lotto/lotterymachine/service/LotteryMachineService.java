package lotto.lotterymachine.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.lotterymachine.domain.LotteryMachine;
import lotto.user.domain.User;
import lotto.util.Score;

public class LotteryMachineService {

    public Map<Score, Integer> ScoreBoard;
    public LotteryMachineService() {
        ScoreBoard = new EnumMap<>(Score.class);
        ScoreBoard.put(Score.ZERO,Score.ZERO.ordinal());
        ScoreBoard.put(Score.ONE,Score.ZERO.ordinal());
        ScoreBoard.put(Score.TWO,Score.ZERO.ordinal());
        ScoreBoard.put(Score.THREE,Score.ZERO.ordinal());
        ScoreBoard.put(Score.FOUR,Score.ZERO.ordinal());
        ScoreBoard.put(Score.FIVE,Score.ZERO.ordinal());
        ScoreBoard.put(Score.FIVE_BONUS,Score.ZERO.ordinal());
        ScoreBoard.put(Score.SIX,Score.ZERO.ordinal());
    }
    public void matchNumber(User user, LotteryMachine lotteryMachine) {
        System.out.println("당첨 통계");
        System.out.println("---");
        checkNumbers(user, lotteryMachine);
        System.out.println(ScoreBoard);
    }

    public void checkNumbers(User user, LotteryMachine lotteryMachine) {
        List<List<Integer>> userLottos = user.getLottos();
        for(List<Integer> userLottory:userLottos) {
            checkTargetNumbers(userLottory,lotteryMachine);
        }
    }
    public void checkTargetNumbers(List<Integer> userLottery,LotteryMachine lotteryMachine){
        int count = Score.ZERO.ordinal() ;
        for (Integer lotteryNumber :userLottery) {
            if(lotteryMachine.getTargetNumbers().contains(lotteryNumber)){
                count++;
            }
        }
        recordScore(userLottery,lotteryMachine.getTargetBonusNumber(),count);
    }
    public boolean recordScore(List<Integer>userLottery,int targetBonusNumber,int count){
        System.out.println(count);

        if(count == Score.FIVE.ordinal()) {
            count = checkBonusNumber(userLottery,targetBonusNumber,count);
            Score score= Score.values()[count];
            ScoreBoard.put(score,ScoreBoard.get(score)+1);
            return true;
        }

        if(count == Score.FIVE_BONUS.ordinal()) {
            Score score= Score.values()[count+1];
            ScoreBoard.put(score,ScoreBoard.get(score)+1);
            return true;
        }
        Score score= Score.values()[count];
        ScoreBoard.put(score,ScoreBoard.get(score)+1);
        System.out.println(ScoreBoard);
        return true;
    }
    public int checkBonusNumber(List<Integer>userLottery,int lotteryMachine,int count) {
        if(userLottery.contains(lotteryMachine)) {
            count = count + 1 ;
            return count;
        }
        return count;
    }
}
