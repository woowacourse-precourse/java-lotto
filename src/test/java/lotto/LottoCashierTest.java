package lotto;

import lotto.lottoCashier.LottoCashier;
import lotto.lottoCashier.LottoCashierImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class LottoCashierTest {
    @Nested
    @DisplayName("ReceiveMoney_Test")
    public class ReceiveMoney_Test {
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

    @Nested
    @DisplayName("calculateNumberOfLottos_Test")
    public class CalculateNumberOfLottos_Test {
        @Test
        void 로또_가격으로_나눠_떨어지지_않는_케이스() {
            //given
            int money = 2350;
            LottoCashier lottoCashier = new LottoCashierImpl();
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
            LottoCashier lottoCashier = new LottoCashierImpl();
            //when
            int numberOfLottoBought = lottoCashier.calculateNumberOfLottos(money);

            //then
            assertThat(numberOfLottoBought)
                    .isEqualTo(2);
        }
    }

    @Nested
    @DisplayName("printNumberPurchased_Test")
    public class PrintNumberPurchased_Test {
        @Test
        void 출력_테스트() {
            //given
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            LottoCashier lottoCashier = new LottoCashierImpl();
            int numberPurchased = 8;
            //when
            lottoCashier.printNumberPurchased(numberPurchased);
            //then
            assertThat(out.toString())
                    .isEqualTo(String.valueOf(numberPurchased)+"개를 구매했습니다.\n");
        }

    }
}
