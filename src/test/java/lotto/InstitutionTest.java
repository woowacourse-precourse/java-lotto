package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class InstitutionTest {

    private static final List<PrizeWinner> prizeWinners = Arrays.asList(PrizeWinner.values());

    @BeforeEach
    void setUp() {
        for(PrizeWinner prizeWinner : prizeWinners) {
            prizeWinner.setCount(0);
        }
    }

    @DisplayName("로또 번호와 당첨 번호의 중복 갯수를 알려준다")
    @Test
    void countPrizeAndLottoDuplicateNumbers() {
        Prize prize = new Prize(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        Integer count = Institution.getInstance().countPrizeAndLottoDuplicatedNumber(lotto.getNumbers(), prize.getNumbers());
        Integer expectCount = 6;

        Assertions.assertEquals(count, expectCount);
    }

    @DisplayName("로또 번호가 보너스 번호를 가지고 있는지 확인한다.")
    @Test
    void isLottoNumberIncludedBonusNumber() {
        Prize prize = new Prize(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));

        Boolean bonusNumberIncluded = Institution.getInstance()
                .isBonusNumberIncluded(lotto.getNumbers(), prize.getBonusNumber());
        Boolean expect = Boolean.TRUE;

        Assertions.assertEquals(bonusNumberIncluded, expect);
    }

    @DisplayName("로또 번호 결과를 확인해서 당첨자를 업데이트 한다.")
    @Test
    void updatePrizeWinnerCount() {
        Prize prize = new Prize(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(List.of(1,2,3,8,9,10));

        Integer count = Institution.getInstance().countPrizeAndLottoDuplicatedNumber(lotto.getNumbers(), prize.getNumbers());

        Boolean bonusNumberIncluded = Institution.getInstance()
                .isBonusNumberIncluded(lotto.getNumbers(), prize.getBonusNumber());

        Institution.getInstance().updatePrizeWinnerCount(prizeWinners, count, bonusNumberIncluded);

        Integer expectedCount = 1;
        PrizeWinner expectedRanking = PrizeWinner.FIFTHPLACE;
        PrizeWinner expectedWinner = prizeWinners.get(prizeWinners.indexOf(expectedRanking));

        Assertions.assertEquals(expectedWinner.getCount(), expectedCount);
    }

    @DisplayName("총 상금의 금액을 계산한다")
    @Test
    void calculateSumOfPrizeMoney() {
        prizeWinners.get(prizeWinners.indexOf(PrizeWinner.FIRSTPLACE)).addCount();

        Long prizeMoneySum = Institution.getInstance().calculateSumOfPrizeMoney(prizeWinners).longValue();
        Long expectedPrizeMoneySum = 2000000000L;

        Assertions.assertEquals(prizeMoneySum, expectedPrizeMoneySum);
    }

    @DisplayName("수익률을 계산한다")
    @Test
    void calculateYield() {
        Long prizeMoneySum = 5000L;
        Integer userMoney = 8000;

        Double yield = Institution.getInstance().calculateYield(prizeMoneySum,userMoney);
        Double expectedYield = (prizeMoneySum.doubleValue()/userMoney);

        Assertions.assertEquals(yield, expectedYield);

    }
}
