package lotto.model;

import lotto.model.statistics.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    @DisplayName("해당하는 순위가 없는 경우")
    void case1() {
        //given
        Integer sameCount = 10;
        Boolean matchBonus = true;

        Assertions.assertThatThrownBy(() -> Rank.of(sameCount, matchBonus)).isInstanceOf(IllegalArgumentException.class);
    }
}
