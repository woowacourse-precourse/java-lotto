package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningStatusTest {

    @DisplayName("3개 일치하는 경우 THREE_NUMBERS_MATCH 값을 반환한다.")
    @Test
    void getLottoWinningStatusByThreeNumbersMatch() {
        Assertions.assertThat(LottoWinningStatus.valueOf(3, true))
                .isEqualTo(LottoWinningStatus.THREE_NUMBERS_MATCH);
        Assertions.assertThat(LottoWinningStatus.valueOf(3, false))
                .isEqualTo(LottoWinningStatus.THREE_NUMBERS_MATCH);
    }

    @DisplayName("5개 일치하는 경우 hasBonusNumber 값에 따라 다른 값을 반환한다.")
    @Test
    void getLottoWinningStatusByFiveNumbersMatchAndHasBonusNumber() {
        Assertions.assertThat(LottoWinningStatus.valueOf(5, true))
                .isEqualTo(LottoWinningStatus.FIVE_NUMBERS_WITH_BONUS_NUMBER_MATCH);
        Assertions.assertThat(LottoWinningStatus.valueOf(5, false))
                .isEqualTo(LottoWinningStatus.FIVE_NUMBERS_MATCH);
    }

    @DisplayName("2개 이하로 일치하는 경우 NOT_WINNING_STATUS 값을 반환한다.")
    @Test
    void getLottoWinningStatusByLessThanTwoNumbersMatch() {
        Assertions.assertThat(LottoWinningStatus.valueOf(2, true))
                .isEqualTo(LottoWinningStatus.NOT_WINNING_STATUS);
        Assertions.assertThat(LottoWinningStatus.valueOf(1, false))
                .isEqualTo(LottoWinningStatus.NOT_WINNING_STATUS);
    }
}
