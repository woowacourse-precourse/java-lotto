package lotto;

import lotto.lottoCashier.LottoCashier;
import lotto.lottoCashier.LottoCashierImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoCashierTest {
    LottoCashier lottoCashier = new LottoCashierImpl();

    @Nested
    @DisplayName("validateMoney_Test")
    public class ValidateMoney_Test {
        @Test
        void 숫자_이외의_값_입력_예외() {
            //given
            String input = "f1";
            //when
            Throwable throwable = catchThrowable(() -> {
                lottoCashier.validateReceivedMoney(input);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void _0보다_작은_값_예외() {
            //given
            String input = "-10000";
            //when
            Throwable throwable = catchThrowable(() -> {
                lottoCashier.validateReceivedMoney(input);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void _소수점_예외() {
            //given
            String input = "10000.123";
            //when
            Throwable throwable = catchThrowable(() -> {
                lottoCashier.validateReceivedMoney(input);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void _성공_테스트() {
            //given
            String input = "10000";

            //when
            Throwable throwable = catchThrowable(() -> {
                lottoCashier.validateReceivedMoney(input);
            });
            //then
            assertThat(throwable)
                    .isEqualTo(null);
        }
    }

    @Nested
    @DisplayName("calculateNumberOfLottos_Test")
    public class CalculateNumberOfLottos_Test {
        @Test
        void 로또_가격으로_나눠_떨어지지_않는_케이스() {
            //given
            int money = 2350;
            //when
            Throwable throwable = catchThrowable(() -> {
                lottoCashier.calculateNumberOfLottos(money);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 로또_가격으로_나눠_떨어지는_케이스() {
            //given
            int money = 2000;
            //when
            int numberOfLottoBought = lottoCashier.calculateNumberOfLottos(money);

            //then
            assertThat(numberOfLottoBought)
                    .isEqualTo(2);
        }
    }
}
