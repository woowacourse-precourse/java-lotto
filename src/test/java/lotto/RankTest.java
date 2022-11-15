package lotto;

import static lotto.rank.Rank.FIFTH;
import static lotto.rank.Rank.FIRST;
import static lotto.rank.Rank.FOURTH;
import static lotto.rank.Rank.NONE;
import static lotto.rank.Rank.SECOND;
import static lotto.rank.Rank.THIRD;
import static lotto.rank.Rank.getRank;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.WinningLotto;
import lotto.rank.Rank;
import lotto.rank.RankChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("사용자의 로또와 당첨 로또를 비교하여 당첨 내역을 계산한다.")
public class RankTest {

    @DisplayName("2개 이하 일치하면 당첨이 아니다.")
    @Test
    void lessThanThreeMatchThenNoneRank() {
        Rank rank1 = getRank(0, true);
        Rank rank2 = getRank(1, true);
        Rank rank3 = getRank(2, false);
        assertThat(rank1).isEqualTo(NONE);
        assertThat(rank2).isEqualTo(NONE);
        assertThat(rank3).isEqualTo(NONE);
    }

    @DisplayName("3개가 일치하면 5등이다.")
    @Test
    void threeMatchThenFifthRank() {
        Rank rank1 = getRank(3, true);
        Rank rank2 = getRank(3, false);
        assertThat(rank1).isEqualTo(FIFTH);
        assertThat(rank2).isEqualTo(FIFTH);
    }

    @DisplayName("4개가 일치하면 4등이다.")
    @Test
    void FourMatchThenFourthRank() {
        Rank rank1 = getRank(4, true);
        Rank rank2 = getRank(4, false);
        assertThat(rank1).isEqualTo(FOURTH);
        assertThat(rank2).isEqualTo(FOURTH);
    }

    @DisplayName("5개가 일치하고 보너스볼이 일치하지 않으면 3등이다.")
    @Test
    void fiveMatchAndBonusNotMatchThenThirdRank() {
        Rank rank = getRank(5, false);
        assertThat(rank).isEqualTo(THIRD);
    }

    @DisplayName("5개가 일치하고 보너스볼이 일치하면 2등이다.")
    @Test
    void fiveMatchAndBonusMatchThenSecondRank() {
        Rank rank = getRank(5, true);
        assertThat(rank).isEqualTo(SECOND);
    }

    @DisplayName("6개가 일치하면 1등이다.")
    @Test
    void sixMatchThenFirstRank() {
        Rank rank = getRank(6, false);
        assertThat(rank).isEqualTo(FIRST);
    }

    @DisplayName("사용자의 로또와 당첨 로또를 비교하여 당첨 내역을 계산한다")
    @Test
    void getRanksByComparingLottoAndWinningLotto() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(generateLottoByIntegerList(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(generateLottoByIntegerList(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(generateLottoByIntegerList(List.of(1, 2, 3, 4, 5, 8)));
        lottos.add(generateLottoByIntegerList(List.of(1, 2, 3, 4, 7, 8)));
        lottos.add(generateLottoByIntegerList(List.of(1, 2, 3, 7, 8, 9)));
        lottos.add(generateLottoByIntegerList(List.of(1, 2, 7, 8, 9, 10)));
        lottos.add(generateLottoByIntegerList(List.of(7, 8, 9, 10, 11, 12)));
        List<LottoNumber> winningNumber = convertIntegerListToLottoNumberList(
                List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        assertThat(RankChecker.checkRank(lottos, winningLotto)).isEqualTo(
                Map.of(FIRST, 1, SECOND, 1, THIRD, 1, FOURTH, 1, FIFTH, 1, NONE, 2));
    }

    private Lotto generateLottoByIntegerList(List<Integer> numbers) {
        return new Lotto(convertIntegerListToLottoNumberList(numbers));
    }

    private List<LottoNumber> convertIntegerListToLottoNumberList(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
