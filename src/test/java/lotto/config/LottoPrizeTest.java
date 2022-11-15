package lotto.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {

    @DisplayName("로또 우승 등급은 5개이다.")
    @Test
    void sizeOfLottoPrize() {
        int result = LottoPrize.values().length;
        Assertions.assertThat(result).isEqualTo(5);
    }

    @DisplayName("1등은 6개의 숫자가 일치한다")
    @Test
    void getFirstPrizeMatchCount() {
        int result = LottoPrize.FIRST_PLACE.getMatchCount();
        Assertions.assertThat(result).isEqualTo(6);

    }

    @DisplayName("5등은 3개의 숫자가 일치한다")
    @Test
    void getFifthPrizeMatchCount() {
        int result = LottoPrize.FIFTH_PLACE.getMatchCount();
        Assertions.assertThat(result).isEqualTo(3);

    }

    @DisplayName("1등의 상금은 2,000,000,000이다.")
    @Test
    void getFirstPrizeWinningMoney() {
        Long result = LottoPrize.FIRST_PLACE.getWinningMoney();
        Assertions.assertThat(result).isEqualTo(2000000000L);
    }

    @DisplayName("5등의 상금은 5,000이다.")
    @Test
    void getFifthPrizeWinningMoney() {
        Long result = LottoPrize.FIFTH_PLACE.getWinningMoney();
        Assertions.assertThat(result).isEqualTo(5000L);
    }

    @DisplayName("2등은 보너스번호가 true이다")
    @Test
    void secondPrizeBonusValue() {
        boolean result = LottoPrize.SECOND_PLACE.getBonus();
        Assertions.assertThat(result).isEqualTo(true);
    }

    @DisplayName("3등은 보너스번호가 false이다")
    @Test
    void thirdPrizeBonusValue() {
        boolean result = LottoPrize.THIRD_PLACE.getBonus();
        Assertions.assertThat(result).isEqualTo(false);
    }
}