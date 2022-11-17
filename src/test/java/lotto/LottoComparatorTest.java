package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoComparatorTest {
    @DisplayName("로또번호 비교 테스트 - 1개")
    @Test
    public void compare1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(44, 22, 33, 12, 1, 9), 6);
        ComparisonToWinningNumberResult result = LottoComparator.compare(lotto, winningNumber);
        assertThat(result.matchCount).isEqualTo(1);
    }

    @DisplayName("로또번호 비교 테스트 - 5개 일치")
    @Test
    public void compare5() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 10), 6);
        ComparisonToWinningNumberResult result = LottoComparator.compare(lotto, winningNumber);
        assertThat(result.matchCount).isEqualTo(5);
    }

    @DisplayName("로또번호 비교 테스트 - 5개, 보너스 일치")
    @Test
    public void compare5AndBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 10), 6);
        ComparisonToWinningNumberResult result = LottoComparator.compare(lotto, winningNumber);
        assertThat(result.matchCount).isEqualTo(5);
    }

    @DisplayName("로또번호 비교 테스트 - 6개")
    @Test
    public void compare6() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 8);
        ComparisonToWinningNumberResult result = LottoComparator.compare(lotto, winningNumber);
        assertThat(result.matchCount).isEqualTo(6);
    }

    @DisplayName("보너스 넘버 비교 테스트 - 일치")
    @Test
    public void compareBonusNum() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 10), 6);
        ComparisonToWinningNumberResult result = LottoComparator.compare(lotto, winningNumber);
        assertThat(result.isBonusMatched).isTrue();
    }

    @DisplayName("보너스 넘버 비교 테스트 - 일치하지 않음")
    @Test
    public void compareDiffBonusNum() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 10), 9);
        ComparisonToWinningNumberResult result = LottoComparator.compare(lotto, winningNumber);
        assertThat(result.isBonusMatched).isFalse();
    }
}