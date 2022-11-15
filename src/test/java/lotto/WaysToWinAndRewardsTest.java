package lotto;

import lotto.lottoChecker.WaysToWinAndRewards;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class WaysToWinAndRewardsTest {
    @Test
    void 부적절한_input_test() {
        //given
        int[] matches = null;
        //when
        Throwable throwable = catchThrowable(() -> {
            WaysToWinAndRewards.findByMatches(matches);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 부적절한_input2_test() {
        //given
        int[] matches = new int[] {1, 2, 3};
        //when
        Throwable throwable = catchThrowable(() -> {
            WaysToWinAndRewards.findByMatches(matches);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 부적절한_input3_test() {
        //given
        int[] matches = new int[] {7, 1};
        //when
        Throwable throwable = catchThrowable(() -> {
            WaysToWinAndRewards.findByMatches(matches);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 부적절한_input4_test() {
        //given
        int[] matches = new int[] {6, 1};
        //when
        Throwable throwable = catchThrowable(() -> {
            WaysToWinAndRewards.findByMatches(matches);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void _1등_test() {
        //given
        int[] matches = new int[] {6, 0};
        //when
        WaysToWinAndRewards rank = WaysToWinAndRewards.findByMatches(matches);
        //then
        assertThat(rank.getRank())
                .isEqualTo(1);
    }
    @Test
    void _2등_test() {
        //given
        int[] matches = new int[] {5, 1};
        //when
        WaysToWinAndRewards rank = WaysToWinAndRewards.findByMatches(matches);
        //then
        assertThat(rank.getRank())
                .isEqualTo(2);
    }
    @Test
    void _3등_test() {
        //given
        int[] matches = new int[] {5, 0};
        //when
        WaysToWinAndRewards rank = WaysToWinAndRewards.findByMatches(matches);
        //then
        assertThat(rank.getRank())
                .isEqualTo(3);
    }
    @Test
    void 순위_외_test() {
        //given
        int[] matches = new int[] {2, 1};
        //when
        WaysToWinAndRewards rank = WaysToWinAndRewards.findByMatches(matches);
        //then
        assertThat(rank.getRank())
                .isEqualTo(-1);
    }
}
