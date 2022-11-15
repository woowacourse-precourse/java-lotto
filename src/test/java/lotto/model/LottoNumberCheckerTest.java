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

    @DisplayName("3등과 5등 보너스 당첨")
    @Test
    void createMatchResult() {
        Lotto winningLotto = new Lotto(makeLotto(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        List<Lotto> lotteries = List.of(
                new Lotto(makeLotto(1, 2, 3, 8, 9, 10)),
                new Lotto(makeLotto(1, 2, 3, 4, 5, 7))
        );
        LottoNumberChecker lottoNumberChecker = new LottoNumberChecker(winningLotto, bonusNumber, lotteries);

        MatchResult matchingLottoResult = lottoNumberChecker.resultOfLotteries();
        assertThat(matchingLottoResult.getTotalPrizeMoney())
                .isEqualTo(MatchType.THREE.getPrizeMoney() + MatchType.FIVE_BONUS.getPrizeMoney());
    }
}