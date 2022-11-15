package lotto.lotterymachine.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.lotterymachine.repository.LotteryMachineRepository;
import lotto.util.Constant;
import lotto.util.Score;
import org.junit.jupiter.api.Test;

class LotteryMachineServiceTest {
    private Map<Score, Integer> ScoreBoard;
    @Test
    void score_board_total_check() {

        LotteryMachineService lotteryMachineService = new LotteryMachineService();
        float target = 1505000.0f;
        ScoreBoard = lotteryMachineService.getScoreBoard();
        for (int i = Constant.INIT_ZERO; i < Score.values().length; i++) {
            ScoreBoard.put(Score.values()[i], Score.ZERO.ordinal());
        }
        ScoreBoard.put(Score.THREE,1);
        ScoreBoard.put(Score.FIVE,1);

        lotteryMachineService.setScoreBoardForTest(ScoreBoard);

        float result = lotteryMachineService.getMoneyToLottery();

        assertThat(target).isEqualTo(result);
    }

    @Test
    void input_score_in_board_test() {
        //when
        LotteryMachineService lotteryMachineService = new LotteryMachineService();
        ScoreBoard = lotteryMachineService.getScoreBoard();
        for (int i = Constant.INIT_ZERO; i < Score.values().length; i++) {
            ScoreBoard.put(Score.values()[i], Score.ZERO.ordinal());
        }
        lotteryMachineService.setScoreBoardForTest(ScoreBoard);
        int target =1 ;
        //then
        lotteryMachineService.featScoreBoardPlusOne(3);

        assertThat(target).isEqualTo(ScoreBoard.get(Score.THREE));
    }
    @Test
    void input_score_if_board_bonus_ball_test() {

        LotteryMachineService lotteryMachineService = new LotteryMachineService();
        final List<Integer> userLottery = List.of(1, 2, 3, 4, 5, 6);
        int testTarget = 1;
        int result =lotteryMachineService.checkBonusNumber(userLottery,1,0);

        assertThat(testTarget).isEqualTo(result);
    }

    @Test
    void input_score_if_won_five_test() {
        LotteryMachineService lotteryMachineService = new LotteryMachineService();
        final List<Integer> userLottery = List.of(1, 2, 3, 4, 5, 6);
        ScoreBoard = lotteryMachineService.getScoreBoard();
        for (int i = Constant.INIT_ZERO; i < Score.values().length; i++) {
            ScoreBoard.put(Score.values()[i], Score.ZERO.ordinal());
        }

        lotteryMachineService.setScoreBoardForTest(ScoreBoard);

        int testTarget = 1;
        lotteryMachineService.setScores(userLottery,11,5);
        assertThat(testTarget).isEqualTo(ScoreBoard.get(Score.FIVE));
    }
    @Test
    void input_score_if_won_five_Bonus_test() {
        LotteryMachineService lotteryMachineService = new LotteryMachineService();
        final List<Integer> userLottery = List.of(1, 2, 3, 4, 5, 6);
        ScoreBoard = lotteryMachineService.getScoreBoard();
        for (int i = Constant.INIT_ZERO; i < Score.values().length; i++) {
            ScoreBoard.put(Score.values()[i], Score.ZERO.ordinal());
        }
        int testTarget = 1;
        lotteryMachineService.setScores(userLottery,1,5);
        assertThat(ScoreBoard.get(Score.FIVE_BONUS)).isEqualTo(testTarget);
    }

    @Test
    void input_score_if_won_six_test() {
        LotteryMachineService lotteryMachineService = new LotteryMachineService();
        final List<Integer> userLottery = List.of(1, 2, 3, 4, 5, 6);
        ScoreBoard = lotteryMachineService.getScoreBoard();
        for (int i = Constant.INIT_ZERO; i < Score.values().length; i++) {
            ScoreBoard.put(Score.values()[i], Score.ZERO.ordinal());
        }

        int testTarget = 1;
        lotteryMachineService.setScores(userLottery,11,6);
        assertThat(testTarget).isEqualTo(ScoreBoard.get(Score.SIX));
    }


}