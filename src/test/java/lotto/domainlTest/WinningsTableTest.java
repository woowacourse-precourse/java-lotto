package lotto.domainlTest;

import lotto.domain.WinningsTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningsTableTest {
    @Test
    @DisplayName("주어진 등수이름과 당첨 테이블과 비교하여 원하는 정보를 찾는지 확인한다.")
    public void checkWinsInformationByMatches() {
        WinningsTable winningsTable = WinningsTable.findByRankName("FIRST");
        assertThat(winningsTable.name()).isEqualTo("FIRST");
    }

    @Test
    @DisplayName("주어진 등수이름과 당첨 테이블과 비교하여 등수에 맞는 추첨 번호를 찾는지 확인한다.")
    public void checkRaffleMatchesByMatches() {
        int raffleMatches = WinningsTable.getRaffleMatchesByMatchState("FIRST");
        assertThat(raffleMatches).isEqualTo(6);
    }

    @Test
    @DisplayName("주어진 등수이름과 당첨 테이블과 비교하여 등수에 맞는 당첨금을 찾는지 확인한다.")
    public void checkWinningsByMatches() {
        String winnings = WinningsTable.getWinningsByMatchState("FIFTH");
        assertThat(winnings).isEqualTo("5,000");
    }
    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 같다면 true를 반환한다.")
    public void checkSameStateBetweenLottoAndRank_right_case() {
        List<Integer> lottoState = List.of(5, 1);
        assertThat(WinningsTable.isSameMatches(WinningsTable.SECOND, lottoState)).isTrue();
    }

    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 다르다면 false를 반환한다.")
    public void checkSameStateBetweenLottoAndRank_wrong_case() {
        List<Integer> lottoState = List.of(5, 1);
        assertThat(WinningsTable.isSameMatches(WinningsTable.THIRD, lottoState)).isFalse();
    }

    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 해당하는 등수 객체를 반환한다.")
    public void findByMatchState() {
        List<Integer> lottoState = List.of(5, 1);
        assertThat(WinningsTable.findByMatches(lottoState)).isEqualTo(WinningsTable.SECOND);
    }

    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 해당하는 등수 객체를 반환한다.")
    public void getRankNames() {
        List<String> rankNames = List.of("FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH");
        assertThat(WinningsTable.getRankNames()).containsExactlyElementsOf(rankNames);
    }

    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 해당하는 등수 이름을 반환한다.")
    public void findRankNameByMatchState() {
        List<Integer> lottoState = List.of(5, 1);
        assertThat(WinningsTable.getRankNameByMatchState(lottoState)).isEqualTo("SECOND");
    }

    @Test
    @DisplayName("로또 번호가 맞춘 추첨 번호의 상태를 보상표와 비교하여 해당하는 등수를 반환한다.")
    public void findWinningsByMatchState() {
        List<Integer> lottoState = List.of(5, 1);
        assertThat(WinningsTable.getWinningsByMatchState(lottoState)).isEqualTo(30000000);
    }
}
