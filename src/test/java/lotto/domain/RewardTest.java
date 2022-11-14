package lotto.domain;

import lotto.service.RankChart;
import lotto.service.RewardChart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RewardTest {

    final Reward reward = new Reward();

    @Nested
    class rewardMoneysTest {

        @DisplayName("6개(1등) 맞추면 1등 상금 주는지")
        @Test
        void firstRewardTest() {
            List<Integer> testFirst = List.of(RankChart.FIRST_PLACE.getValue());
            boolean result = reward.rewardMoneys(testFirst)
                    .contains(RewardChart.FIRST_REWARD.getValue());
            assertTrue(result);
        }

        @DisplayName("5개 + 보너스 번호(2등) 맞추면 2등 상금 주는지")
        @Test
        void secondRewardTest() {
            List<Integer> testSecond = List.of(RankChart.SECOND_PLACE.getValue());
            boolean result = reward.rewardMoneys(testSecond)
                    .contains(RewardChart.SECOND_REWARD.getValue());
            assertTrue(result);
        }

        @DisplayName("5개(3등) 맞추면 3등 상금 주는지")
        @Test
        void thirdRewardTest() {
            List<Integer> testThird = List.of(RankChart.THIRD_PLACE.getValue());
            boolean result = reward.rewardMoneys(testThird)
                    .contains(RewardChart.THIRD_REWARD.getValue());
            assertTrue(result);
        }

        @DisplayName("4개(4등) 맞추면 4등 상금 주는지")
        @Test
        void fourthRewardTest() {
            List<Integer> testFourth = List.of(RankChart.FOURTH_PLACE.getValue());
            boolean result = reward.rewardMoneys(testFourth)
                    .contains(RewardChart.FOURTH_REWARD.getValue());
            assertTrue(result);
        }

        @DisplayName("3개(5등) 맞추면 5등 상금 주는지")
        @Test
        void fifthRewardTest() {
            List<Integer> testFifth = List.of(RankChart.FIFTH_PLACE.getValue());
            boolean result = reward.rewardMoneys(testFifth)
                    .contains(RewardChart.FIFTH_REWARD.getValue());
            assertTrue(result);
        }

        @DisplayName("2개 이하로 맞추면 아무 보상 없는지")
        @Test
        void notRewardTest() {
            List<Integer> testFirst = List.of(2);
            boolean result = reward.rewardMoneys(testFirst)
                    .contains(0);
            assertTrue(result);
        }
    }

}