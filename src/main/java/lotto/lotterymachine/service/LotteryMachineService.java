package lotto.lotterymachine.service;

import static lotto.util.Constant.NEXT_INDEX;
import static lotto.util.Constant.PERCENTAGE_HUNDRED;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.lotterymachine.domain.LotteryMachine;
import lotto.user.domain.User;
import lotto.util.Constant;
import lotto.util.Score;

public class LotteryMachineService {
    private Map<Score, Integer> ScoreBoard;

    public LotteryMachineService() {
        ScoreBoard = new EnumMap<>(Score.class);
        for (int i = Constant.INIT_ZERO; i < Score.values().length; i++) {
            ScoreBoard.put(Score.values()[i], Score.ZERO.ordinal());
        }
    }

    public Map<Score, Integer> checkNumbers(User user, LotteryMachine lotteryMachine) {
        List<List<Integer>> userLottos = user.getLottos();
        for (List<Integer> userLottory : userLottos) {
            checkTargetNumbers(userLottory, lotteryMachine);
        }
        return ScoreBoard;
    }

    public void checkTargetNumbers(List<Integer> userLottery, LotteryMachine lotteryMachine) {
        int count = Score.ZERO.ordinal();
        for (Integer lotteryNumber : userLottery) {
            if (lotteryMachine.getTargetNumbers().contains(lotteryNumber)) {
                count++;
            }
        }
        setScores(userLottery, lotteryMachine.getTargetBonusNumber(), count);
    }

    public void setScores(List<Integer> userLottery, int targetBonusNumber, int count) {

        if (count == Score.FIVE.ordinal()) {
            count = checkBonusNumber(userLottery, targetBonusNumber, count);
            featScoreBoardPlusOne(count);
            return;
        }

        if (count == Score.FIVE_BONUS.ordinal()) {
            featScoreBoardPlusOne(count + NEXT_INDEX);
            return;
        }
        featScoreBoardPlusOne(count);
    }

    public int checkBonusNumber(List<Integer> userLottery, int targetBonusNumber, int count) {
        if (userLottery.contains(targetBonusNumber)) {
            count = count + NEXT_INDEX;
            return count;
        }
        return count;
    }

    public void featScoreBoardPlusOne(int index) {
        Score score = Score.values()[index];
        ScoreBoard.put(score, ScoreBoard.get(score) + NEXT_INDEX);
    }

    public float getIncome(int inputMoney) {
        return ((getMoneyToLottery() / inputMoney) * PERCENTAGE_HUNDRED);
    }

    public float getMoneyToLottery() {
        int prize = Constant.INIT_ZERO;
        for (int i = Score.THREE.ordinal(); i < Score.SIX.ordinal(); i++) {
            prize += (ScoreBoard.get(Score.values()[i]) * Score.values()[i].getValue());
        }
        return prize;
    }

    public Map<Score, Integer> getScoreBoard() {
        return ScoreBoard;
    }
    public void setScoreBoardForTest(Map<Score, Integer> scoreBoard){
        this.ScoreBoard = scoreBoard;
    }
}
