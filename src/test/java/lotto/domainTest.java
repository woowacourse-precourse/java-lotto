package lotto;

import domain.LottoIssue;
import domain.Profit;
import domain.WinningConfirmation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class domainTest {
    @DisplayName("금액에 맞게 로또 발행")
    @Test
    void 금액에_맞는_로또발행_테스트() {
        LottoIssue issue = new LottoIssue();
        assertThat(issue.issueLotto("8000")).isEqualTo(8);
    }

    @DisplayName("금액입력 예외처리")
    @Test
    void 금액입력_예외처리_테스트() {
        assertThatThrownBy(() -> LottoIssue.handleInputMoneyException("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 갯수 확인")
    @Test
    void 당첨번호_갯수확인_테스트() {
        WinningConfirmation matchCount = new WinningConfirmation();
        assertThat(matchCount.getMatchCount(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7)))
                .isEqualTo(5);
    }

    @DisplayName("보너스 번호 확인")
    @Test
    void 보너스번호_일치확인_테스트() {
        WinningConfirmation bonus = new WinningConfirmation();
        assertThat(bonus.isBonus(List.of(1, 2, 3, 4, 5, 6), 3)).isEqualTo(true);
        assertThat(bonus.isBonus(List.of(1, 2, 3, 4, 5, 6), 8)).isEqualTo(false);
    }

    @DisplayName("로또 순위 확인")
    @Test
    void 로또순위_테스트() {
        WinningConfirmation rank = new WinningConfirmation();
        assertThat(rank.getRank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(rank.getRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(rank.getRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(rank.getRank(0, true)).isEqualTo(Rank.LOSE);

    }
    @DisplayName("수익율 확인")
    @Test
    void 수익율_확인_테스트(){
        Profit profit = new Profit();
        assertThat(profit.getProfit(5000,8000)).isEqualTo("62.5%");
    }
}
