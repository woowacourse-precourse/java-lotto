package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("당첨 번호와 같은 번호의 수, 보너스 번호와 같은 번호의 수에 대응되는 등수는 존재한다.")
    @Test
    void getRank_Present() {
        assertThat(Rank.getRank(5, 1)).isPresent();
    }

    @DisplayName("당첨 번호와 같지 않은 번호의 수, 보너스 번호와 같지 않은 번호의 수에 대응되는 등수는 존재하지 않는다.")
    @Test
    void getRank_Empty() {
        assertThat(Rank.getRank(7, 0)).isEmpty();
    }

}
