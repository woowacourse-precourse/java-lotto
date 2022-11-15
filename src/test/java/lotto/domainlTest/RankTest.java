package lotto.domainlTest;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 같다면 true를 반환한다.")
    public void checkSameStateBetweenLottoAndRank_right_case() {
        List<Integer> lottoState = List.of(5, 1);
        assertThat(Rank.isSame(Rank.SECOND, lottoState)).isTrue();
    }

    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 다르다면 false를 반환한다.")
    public void checkSameStateBetweenLottoAndRank_wrong_case() {
        List<Integer> lottoState = List.of(5, 1);
        assertThat(Rank.isSame(Rank.THIRD, lottoState)).isFalse();
    }

    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 해당하는 등수 객체를 반환한다.")
    public void findByMatchState() {
        List<Integer> lottoState = List.of(5, 1);
        assertThat(Rank.findByMatches(lottoState)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 해당하는 등수 객체를 반환한다.")
    public void getRankNames() {
        List<String> rankNames = List.of("FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH");
        assertThat(Rank.getRankNames()).containsExactlyElementsOf(rankNames);
    }

    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 해당하는 등수 이름을 반환한다.")
    public void findRankNameByMatchState() {
        List<Integer> lottoState = List.of(5, 1);
        assertThat(Rank.getRankNameByMatchState(lottoState)).isEqualTo("SECOND");
    }

    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 해당하는 등수를 반환한다.")
    public void findWinningsByMatchState() {
        List<Integer> lottoState = List.of(5, 1);
        assertThat(Rank.getWinningsByMatchState(lottoState)).isEqualTo(30000000);
    }
}
