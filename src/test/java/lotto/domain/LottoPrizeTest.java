package lotto.domain;

import lotto.domain.LottoPrize;
import lotto.domain.LottoWinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoPrizeTest {

    @Test
    @DisplayName("사용자의 로또 번호와 당첨 번호를 비교하여 일치하는 개수를 리턴한다.")
    void 당첨_개수_테스트() throws Exception {
        //given
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        Field winningNums = lottoWinningNumber.getClass().getDeclaredField("winningNums");
        winningNums.setAccessible(true);
        winningNums.set(lottoWinningNumber, List.of(3, 4, 5, 7, 8, 9));

        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumber);
        Method method = lottoPrize.getClass().getDeclaredMethod("getMatchCount", List.class);
        method.setAccessible(true);

        //when
        List<Integer> userNums = List.of(1, 2, 3, 4, 5, 6);

        //then
        int matchCount = (int) method.invoke(lottoPrize, userNums);
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("5개가 일치하면서 보너스 번호가 일치할 때 결과값으로 50을 받아야 한다.")
    void 보너스_번호_체크_테스트() throws Exception {
        //given
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        Field bonusNum = lottoWinningNumber.getClass().getDeclaredField("bonusNum");
        bonusNum.setAccessible(true);
        bonusNum.set(lottoWinningNumber, 7);

        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumber);
        Method method = lottoPrize.getClass().getDeclaredMethod("checkBonusNumber", List.class, int.class);
        method.setAccessible(true);

        //when
        List<Integer> userNums = List.of(1, 2, 3, 4, 5, 7);

        //then
        int matchCount = (int) method.invoke(lottoPrize, userNums, 5);
        assertThat(matchCount).isEqualTo(50);
    }

    @Test
    @DisplayName("당첨 개수에 따라 올바른 당첨 금액을 리턴해야 한다.")
    void 당첨_금액_테스트() throws Exception {
        //given
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumber);

        Method addCountMethod = lottoPrize.getClass().getDeclaredMethod("addMatchCount", int.class);
        addCountMethod.setAccessible(true);

        Method winningAmountMethod = lottoPrize.getClass().getDeclaredMethod("getTotalWinningAmount");
        winningAmountMethod.setAccessible(true);

        //when
        addCountMethod.invoke(lottoPrize, 3);
        addCountMethod.invoke(lottoPrize, 4);

        //then
        long totalWinningAmount = (long) winningAmountMethod.invoke(lottoPrize);
        assertThat(totalWinningAmount).isEqualTo(55_000);
    }

    @Test
    @DisplayName("구매 금액과 당첨 금액에 따라 올바른 수익률을 리턴해야 된다.")
    void 수익률_계산_테스트() throws Exception {
        //given
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        LottoPrize lottoPrize = new LottoPrize(lottoWinningNumber);
        Method method = lottoPrize.getClass().getDeclaredMethod("computeEarningRate", int.class, long.class);
        method.setAccessible(true);

        //when
        int purchaseAmount = 80_000;
        int winningZeroAmount = 0;
        int winningAmount = 15_000;

        //then
        String zeroRate = (String) method.invoke(lottoPrize, purchaseAmount, winningZeroAmount);
        assertThat(zeroRate).isEqualTo("0");

        String earningRate = (String) method.invoke(lottoPrize, purchaseAmount, winningAmount);
        assertThat(earningRate).isEqualTo("18.8");
    }
}