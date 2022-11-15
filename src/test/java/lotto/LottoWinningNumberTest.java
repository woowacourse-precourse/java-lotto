package lotto;

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

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}