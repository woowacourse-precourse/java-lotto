package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    private final Lotto WINNING_NUMBERS = new Lotto(createLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));

    @DisplayName("당첨 번호에 보너스 번호가 포함되면 예외가 발생한다.")
    @Test
    void createWinningResultByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningResult(WINNING_NUMBERS, new LottoNumber(3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호가 당첨 번호에 포함되어 있습니다.");
    }

    @DisplayName("보너스 번호가 1~45 범위 밖이면 예외가 발생한다.")
    @Test
    void createWinningResultByRange() {
        assertThatThrownBy(() -> new WinningResult(WINNING_NUMBERS, new LottoNumber(55)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 범위 밖의 숫자가 포함되어 있습니다.");
    }

    @DisplayName("당첨 번호와 로또 번호가 같으면 1등이다.")
    @Test
    void check1stLotto() {
        WinningResult winningResult = new WinningResult(WINNING_NUMBERS, new LottoNumber(7));

        Rank rank = winningResult.check(WINNING_NUMBERS);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("발행한 로또들과 당첨번호를 비교하여 당첨 통계를 낸다.")
    @Test
    void compileStatistics() {
        WinningResult winningResult = new WinningResult(WINNING_NUMBERS, new LottoNumber(7));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(WINNING_NUMBERS);
        lottos.add(new Lotto(createLottoNumbers(List.of(10, 11, 12, 13, 14, 15))));

        WinningStatistics winningStatistics = winningResult.compileStatistics(lottos);
        int firstRankCount = winningStatistics.countWonLottosByRank(Rank.FIRST);
        int bangCount = winningStatistics.countWonLottosByRank(Rank.BANG);

        assertThat(firstRankCount).isEqualTo(1);
        assertThat(bangCount).isEqualTo(1);
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}