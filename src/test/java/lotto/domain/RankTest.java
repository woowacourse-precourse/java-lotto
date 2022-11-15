package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("당첨 번호와 같은 번호의 수, 보너스 번호와 같은 번호의 수에 대응되는 등수를 확인한다.")
    @Test
    void getRank() {
        assertThat(Rank.getRank(5, 1)).isPresent();
        assertThat(Rank.getRank(7, 0)).isEmpty();
    }

}
