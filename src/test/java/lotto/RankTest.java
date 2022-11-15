package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("Rank numberOfMatching 메소드 확인")
    @Test
    void numberOfMatchingMethodOfRankValidate() {
        // given
        List<Float> numberOfMatching = Rank.getNumbersOfMatching();
        List<Float> compare = List.of(3f, 4f, 5f, 5.5f, 6f);

        // then
        assertThat(numberOfMatching.containsAll(compare)).isTrue();
    }

    @DisplayName("Rank getPrize 메소드 확인")
    @Test
    void getPrizeMethodOfRankValidate() {
        // given
        long prize = Rank.getPrize(5.5f);

        // then
        assertThat(prize).isEqualTo(30_000_000);
    }
}
