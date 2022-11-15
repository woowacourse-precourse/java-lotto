package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberCheckerTest {
    Set<LottoNumber> makeLotto(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    @DisplayName("3등과 5등 보너스 당첨했을 때 당첨금과 당첨 개수 비교")
    @Test
    void createMatchResult() {
        Lotto winningLotto = new Lotto(makeLotto(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        List<Lotto> lotteries = List.of(
                new Lotto(makeLotto(1, 2, 3, 8, 9, 10)),
                new Lotto(makeLotto(1, 2, 3, 4, 5, 7))
        );
        LottoNumberChecker lottoNumberChecker = new LottoNumberChecker(winningLotto, bonusNumber, lotteries);

        MatchResult matchResult = lottoNumberChecker.resultOfLotteries();
        assertThat(matchResult.getTotalPrizeMoney())
                .isEqualTo(MatchType.THREE.getPrizeMoney() + MatchType.FIVE_BONUS.getPrizeMoney());
        assertThat(matchResult.getResultByMatchType(MatchType.THREE)).isEqualTo(1);
        assertThat(matchResult.getResultByMatchType(MatchType.FOUR)).isEqualTo(0);
        assertThat(matchResult.getResultByMatchType(MatchType.FIVE)).isEqualTo(0);
        assertThat(matchResult.getResultByMatchType(MatchType.FIVE_BONUS)).isEqualTo(1);
        assertThat(matchResult.getResultByMatchType(MatchType.SIX)).isEqualTo(0);
    }

    @DisplayName("모든 등수 1개씩 당첨했을 때 당첨금과 당첨 개수 비교")
    @Test
    void createMatchResult2() {
        Lotto winningLotto = new Lotto(makeLotto(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        List<Lotto> lotteries = List.of(
                new Lotto(makeLotto(1, 2, 3, 7, 8, 9)),
                new Lotto(makeLotto(1, 2, 3, 4, 8, 9)),
                new Lotto(makeLotto(1, 2, 3, 4, 5, 8)),
                new Lotto(makeLotto(1, 2, 3, 4, 5, 7)),
                new Lotto(makeLotto(1, 2, 3, 4, 5, 6))
        );
        LottoNumberChecker lottoNumberChecker = new LottoNumberChecker(winningLotto, bonusNumber, lotteries);

        MatchResult matchResult = lottoNumberChecker.resultOfLotteries();
        assertThat(matchResult.getTotalPrizeMoney())
                .isEqualTo(Arrays.stream(MatchType.values())
                        .mapToInt(MatchType::getPrizeMoney)
                        .sum());
        assertThat(matchResult.getResultByMatchType(MatchType.THREE)).isEqualTo(1);
        assertThat(matchResult.getResultByMatchType(MatchType.FOUR)).isEqualTo(1);
        assertThat(matchResult.getResultByMatchType(MatchType.FIVE)).isEqualTo(1);
        assertThat(matchResult.getResultByMatchType(MatchType.FIVE_BONUS)).isEqualTo(1);
        assertThat(matchResult.getResultByMatchType(MatchType.SIX)).isEqualTo(1);
    }
}