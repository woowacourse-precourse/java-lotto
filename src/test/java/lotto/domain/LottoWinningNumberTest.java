package lotto.domain;

import lotto.domain.LottoWinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningNumberTest {
    @Test
    @DisplayName("올바른 당첨 번호가 들어왔을 때 정수 리스트가 반환되어야 된다.")
    void 당첨_번호_리스트_테스트() throws Exception {
        //given
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        Method method = lottoWinningNumber.getClass().getDeclaredMethod("getWinningNumbers");
        method.setAccessible(true);

        //when
        command("1,2,3,4,5,6");
        List<Integer> winningNumbers = (List<Integer>) method.invoke(lottoWinningNumber);

        //then
        assertThat(winningNumbers)
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("올바른 당첨, 보너스 번호가 들어왔을 때 해당 정보를 정상적으로 리턴해야 한다.")
    void 당첨_번호_보너스_번호_통합_테스트() throws Exception {
        //given
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();

        //when
        command("1,2,3,4,5,6", "7");
        LottoWinningNumber winningNumbersInfo = lottoWinningNumber.getWinningNumbersInfo();

        //then
        List<Integer> winningNums = List.of(1,2,3,4,5,6);
        Integer bonusNum = 7;

        assertThat(winningNumbersInfo).isNotNull();
        assertThat(winningNumbersInfo.getWinningNums()).isEqualTo(winningNums);
        assertThat(winningNumbersInfo.getBonusNum()).isEqualTo(bonusNum);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}