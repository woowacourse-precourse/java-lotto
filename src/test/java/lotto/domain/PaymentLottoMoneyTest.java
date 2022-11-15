package lotto.domain;

import lotto.utils.ExceptionMessages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 구입 금액, 구입 개수 테스트")
class PaymentLottoMoneyTest {
    @Nested
    @DisplayName("로또 구입 금액 유효성 예외테스트")
    class PaymentLottoMoneyExceptionTest {
        @Test
        @DisplayName("로또 구입 금액에 숫자가 아닌 것이 있으면 예외 발생")
        void hasNotNumberExceptionTest() {
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new PaymentLottoMoney("1000 "));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.PAYMENT_ONLY_NUMBER);
        }

        @Test
        @DisplayName("로또구입금액이 천원 단위가 아니면 예외발생")
        void notThousandUnitExceptionTest() {
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new PaymentLottoMoney("1100"));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.PAYMENT_ONLY_ONE_THOUSAND_UNIT);
        }

        @Test
        @DisplayName("로또구입금액이 천원 미만이면 예외발생")
        void lessThanThousandExceptionTest() {
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new PaymentLottoMoney("900"));
            assertThat(exception.getMessage()).isEqualTo(ExceptionMessages.PAYMENT_ONLY_ONE_THOUSAND_UNIT);
        }
    }

    @Nested
    @DisplayName("로또 구입 개수 반환 테스트")
    class CountNumberOfBuyLottoTest {
        @Test
        @DisplayName("로또구입 개수 테스트")
        void calculateNumberOfLotto() {
            PaymentLottoMoney paymentLottoMoney = new PaymentLottoMoney("10000");
            int lottoCount = paymentLottoMoney.calculateNumberOfLotto();
            int expectedLottoCount = 10;
            assertThat(lottoCount).isEqualTo(expectedLottoCount);
        }

        @Test
        @DisplayName("로또 한개 구입 개수 테스트")
        void buyOneLottoTest() {
            PaymentLottoMoney paymentLottoMoney = new PaymentLottoMoney("1000");
            int lottoCount = paymentLottoMoney.calculateNumberOfLotto();
            int expectedLottoCount = 1;
            assertThat(lottoCount).isEqualTo(expectedLottoCount);
        }
    }

}