package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PriceCheckerTest {

    @Test
    public void lottoNumberChecking() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        PrizeDetails prizeCount = PriceChecker.getPrizeCount(lotto.getNumbers(), lotto2.getNumbers());
        assertThat(prizeCount).isEqualTo(PrizeDetails.SIX_PRIZE);
    }

    @Test
    public void bonusChecking() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lotto.setPriceDetails(PrizeDetails.FIVE_PRIZE);
        PrizeDetails prizeDetails = PriceChecker.updateLottoPrizeDetailsWhenHasBonusNumber(lotto, 7);
        assertThat(prizeDetails).isEqualTo(PrizeDetails.FIVE_PRIZE_AND_BONUS);
    }

}