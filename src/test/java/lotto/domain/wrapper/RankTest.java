package lotto.domain.wrapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {


    @DisplayName("1등부터 5등까지 전부 당첨되었을 때 검증")
    @Test
    public void rankPrizeValueTest() throws Exception {
        int totalPrize = 0;
        for (Rank value : Rank.values()) {
            totalPrize += value.currentPrize();
        }
        Assertions.assertThat(totalPrize).isEqualTo(2031555000);
    }

}
