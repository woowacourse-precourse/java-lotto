package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {
    @DisplayName("일치하는 숫자가 6개일 때 1등을 반환한다.")
    @Test
    public void returnFirstPrizeWhenMatchCountIs6() {
        ComparisonToWinningNumberResult mockResult = new ComparisonToWinningNumberResult(6, true);
        LottoPrize prizeOfResult = LottoPrize.of(mockResult);
        assertThat(prizeOfResult).isEqualTo(LottoPrize.FIRST);
    }

    @DisplayName("일치하는 숫자가 5개이고 보너스 번호가 일치할 때 2등을 반환한다.")
    @Test
    public void returnSecondPrizeWhenMatchCountIs5AndMatchedBonus() {
        ComparisonToWinningNumberResult mockResult = new ComparisonToWinningNumberResult(5, true);
        LottoPrize prizeOfResult = LottoPrize.of(mockResult);
        assertThat(prizeOfResult).isEqualTo(LottoPrize.SECOND);
    }

    @DisplayName("일치하는 숫자가 5개이고 보너스 번호가 일치하지 않을 때 3등을 반환한다.")
    @Test
    public void returnThirdPrizeWhenMatchCountIs5AndDoesNotMatchBonus() {
        ComparisonToWinningNumberResult mockResult = new ComparisonToWinningNumberResult(5, false);
        LottoPrize prizeOfResult = LottoPrize.of(mockResult);
        assertThat(prizeOfResult).isEqualTo(LottoPrize.THIRD);
    }

    @DisplayName("일치하는 숫자가 4개일 때 4등을 반환한다.")
    @Test
    public void returnFourthPrizeWhenMatchCountIs4() {
        ComparisonToWinningNumberResult mockResult = new ComparisonToWinningNumberResult(4, true);
        LottoPrize prizeOfResult = LottoPrize.of(mockResult);
        assertThat(prizeOfResult).isEqualTo(LottoPrize.FOURTH);
    }

    @DisplayName("일치하는 숫자가 3개일 때 5등을 반환한다.")
    @Test
    public void returnFifthPrizeWhenMatchCountIs3() {
        ComparisonToWinningNumberResult mockResult = new ComparisonToWinningNumberResult(3, false);
        LottoPrize prizeOfResult = LottoPrize.of(mockResult);
        assertThat(prizeOfResult).isEqualTo(LottoPrize.FIFTH);
    }

    @DisplayName("일치하는 숫자가 3개 미만일때 NONE을 반환한다.")
    @Test
    public void returnNoneWhenMatchCountIsLessThan3() {
        ComparisonToWinningNumberResult mockResult = new ComparisonToWinningNumberResult(2, true);
        LottoPrize prizeOfResult = LottoPrize.of(mockResult);
        assertThat(prizeOfResult).isEqualTo(LottoPrize.NONE);
    }
}