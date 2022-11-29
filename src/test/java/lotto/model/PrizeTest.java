package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeTest {

    private final String THREE_STRIKE_MESSAGE = "3개 일치 (5,000원)";
    private final String FOUR_STRIKE_MESSAGE = "4개 일치 (50,000원)";
    private final String FIVE_STRIKE_MESSAGE = "5개 일치 (1,500,000원)";
    private final String FIVE_STRIKE_WITH_BONUS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    private final String SIX_STRIKE_MESSAGE = "6개 일치 (2,000,000,000원)";

    @DisplayName("점수별로 당첨 갯수에 따라 당첨 금액을 계산한다")
    @Test
    void calculateProfitByPrize() {
        assertEquals(Prize.THREE_STRIKE.calculate(2), 2 * 5000);
        assertEquals(Prize.FOUR_STRIKE.calculate(2), 2 * 50000);
        assertEquals(Prize.FIVE_STRIKE.calculate(2), 2 * 1500000);
        assertEquals(Prize.FIVE_STRIKE_WITH_BONUS.calculate(2), 2 * 30000000);
        assertEquals(Prize.SIX_STRIKE.calculate(2), 2 * 2000000000);
    }

    @DisplayName("당첨 갯수에 따른 메세지를 반환한다.")
    @Test
    void getMessageByPrizeScore() {
        assertEquals(Prize.THREE_STRIKE.getMessage(), THREE_STRIKE_MESSAGE);
        assertEquals(Prize.FOUR_STRIKE.getMessage(), FOUR_STRIKE_MESSAGE);
        assertEquals(Prize.FIVE_STRIKE.getMessage(), FIVE_STRIKE_MESSAGE);
        assertEquals(Prize.FIVE_STRIKE_WITH_BONUS.getMessage(), FIVE_STRIKE_WITH_BONUS_MESSAGE);
        assertEquals(Prize.SIX_STRIKE.getMessage(), SIX_STRIKE_MESSAGE);
    }
}