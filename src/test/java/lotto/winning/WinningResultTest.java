package lotto.winning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    @Test
    public void generateSuccessTest() throws Exception {
        // given
        List<Integer> matchedCounts = List.of(0, 1, 2, 3, 4, 5, 6);

        // when
        List<WinningResult> winningBonusFalseResults = matchedCounts.stream()
                .map(matchedCount -> WinningResult.generate(matchedCount, false)).collect(Collectors.toList());
        List<WinningResult> winningBonusTrueResults = matchedCounts.stream()
                .map(matchedCount -> WinningResult.generate(matchedCount, true)).collect(Collectors.toList());


        // then
        assertThat(winningBonusFalseResults.get(0)).isEqualTo(WinningResult.NOTHING);
        assertThat(winningBonusFalseResults.get(1)).isEqualTo(WinningResult.NOTHING);
        assertThat(winningBonusFalseResults.get(2)).isEqualTo(WinningResult.NOTHING);
        assertThat(winningBonusFalseResults.get(3)).isEqualTo(WinningResult.FIFTH_PRIZE);
        assertThat(winningBonusFalseResults.get(4)).isEqualTo(WinningResult.FORTH_PRIZE);
        assertThat(winningBonusFalseResults.get(5)).isEqualTo(WinningResult.THIRD_PRIZE);
        assertThat(winningBonusFalseResults.get(6)).isEqualTo(WinningResult.FIRST_PRIZE);

        assertThat(winningBonusTrueResults.get(0)).isEqualTo(WinningResult.NOTHING);
        assertThat(winningBonusTrueResults.get(1)).isEqualTo(WinningResult.NOTHING);
        assertThat(winningBonusTrueResults.get(2)).isEqualTo(WinningResult.NOTHING);
        assertThat(winningBonusTrueResults.get(3)).isEqualTo(WinningResult.FIFTH_PRIZE);
        assertThat(winningBonusTrueResults.get(4)).isEqualTo(WinningResult.FORTH_PRIZE);
        assertThat(winningBonusTrueResults.get(5)).isEqualTo(WinningResult.SECOND_PRIZE);
        assertThat(winningBonusTrueResults.get(6)).isEqualTo(WinningResult.FIRST_PRIZE);
    }
}