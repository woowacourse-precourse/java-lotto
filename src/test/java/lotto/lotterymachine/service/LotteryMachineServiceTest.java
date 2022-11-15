package lotto.lotterymachine.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import lotto.lotterymachine.repository.LotteryMachineRepository;
import lotto.util.Constant;
import lotto.util.Score;
import org.junit.jupiter.api.Test;

class LotteryMachineServiceTest {
    private Map<Score, Integer> ScoreBoard;

    @Test
    void map_test() {
        final Map<String, Integer> map = new HashMap<>();
        map.put("aa",1);
        map.put("aa",map.get("aa")+1);
        System.out.println(map);
    }
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




}