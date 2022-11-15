package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class InstitutionTest {

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
        Boolean expect = Boolean.FALSE;

        Assertions.assertEquals(bonusNumberIncluded, expect);
    }

    @DisplayName("로또 번호 결과를 확인해서 당첨자를 업데이트 한다.")
    @Test
    void updatePrizeWinnerCount() {
        Prize prize = new Prize(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(List.of(1,2,3,8,9,10));
        List<PrizeWinner> prizeWinners = Arrays.asList(PrizeWinner.values());

        Integer count = Institution.getInstance().countPrizeAndLottoDuplicatedNumber(lotto.getNumbers(), prize.getNumbers());

        Boolean bonusNumberIncluded = Institution.getInstance()
                .isBonusNumberIncluded(lotto.getNumbers(), prize.getBonusNumber());

        Institution.getInstance().updatePrizeWinnerCount(prizeWinners, count, bonusNumberIncluded);

        Integer expected = 1;
        PrizeWinner expectedRanking = PrizeWinner.FIFTHPLACE;
        PrizeWinner expectedWinner = prizeWinners.get(prizeWinners.indexOf(expectedRanking));

        Assertions.assertEquals(expectedWinner.getCount(), expected);
    }
}
