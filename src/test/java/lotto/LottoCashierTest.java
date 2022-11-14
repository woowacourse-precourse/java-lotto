package lotto;

import lotto.lottoCashier.LottoCashier;
import lotto.lottoCashier.LottoCashierImpl;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class LottoCashierTest {
    @Test
    void 숫자_이외의_값_입력_예외() {
        //given
        LottoCashier lottoCashier = new LottoCashierImpl();
        String input = "f1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        Throwable throwable = catchThrowable(() -> {
            lottoCashier.receiveMoney();
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void _0보다_작은_값_예외() {
        //given
        LottoCashier lottoCashier = new LottoCashierImpl();
        String input = "-10000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        Throwable throwable = catchThrowable(() -> {
            lottoCashier.receiveMoney();
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void _소수점_예외() {
        //given
        LottoCashier lottoCashier = new LottoCashierImpl();
        String input = "10000.123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        Throwable throwable = catchThrowable(() -> {
            lottoCashier.receiveMoney();
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void _성공_테스트() {
        //given
        LottoCashier lottoCashier = new LottoCashierImpl();
        String input = "10000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        int money = lottoCashier.receiveMoney();
        //then
        assertThat(money)
                .isEqualTo(Integer.parseInt(input));
    }
}
