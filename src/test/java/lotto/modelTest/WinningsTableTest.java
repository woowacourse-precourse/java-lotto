package lotto.modelTest;

import lotto.model.WinningsTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningsTableTest {
    @Test
    @DisplayName("주어진 등수이름과 당첨 테이블과 비교하여 원하는 정보를 찾는지 확인한다.")
    public void checkWinsInformationByMatches() {
        WinningsTable winningsTable = WinningsTable.findByMatches("FIRST");
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
}
