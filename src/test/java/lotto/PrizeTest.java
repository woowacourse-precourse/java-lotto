package lotto;

import lotto.domain.Prize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PrizeTest {

    @DisplayName("일치하는 번호가 3개 미만이면 당첨되지 않는다.")
    @Test
    void givenPrizeFail() {
        Prize prize = Prize.getMatchPrize(2, false);
        Assertions.assertEquals(prize, Prize.FAIL);
    }

    @DisplayName("일치하는 번호가 3개면 5등에 당첨된다.")
    @Test
    void givenPrizeFifth() {
        Prize prize = Prize.getMatchPrize(3, false);
        Assertions.assertEquals(prize, Prize.FIFTH);
    }

    @DisplayName("일치하는 번호가 4개면 4등에 당첨된다.")
    @Test
    void givenPrizeForth() {
        Prize prize = Prize.getMatchPrize(4, false);
        Assertions.assertEquals(prize, Prize.FORTH);
    }

    @DisplayName("일치하는 번호가 5개고 보너스 번호는 미포함이면 3등에 당첨된다.")
    @Test
    void givenPrizeThird() {
        Prize prize = Prize.getMatchPrize(4, false);
        Assertions.assertEquals(prize, Prize.FORTH);
    }

    @DisplayName("일치하는 번호가 5개고 보너스 번호가 포함이면 2등에 당첨된다.")
    @Test
    void givenPrizeSecond() {
        Prize prize = Prize.getMatchPrize(5, true);
        Assertions.assertEquals(prize, Prize.SECOND);
    }

    @DisplayName("일치하는 번호가 6개면 1등에 당첨된다.")
    @Test
    void givenPrizeFirst() {
        Prize prize = Prize.getMatchPrize(6, false);
        Assertions.assertEquals(prize, Prize.FIRST);
    }


}
