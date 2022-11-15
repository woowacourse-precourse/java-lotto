package lotto;

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

}