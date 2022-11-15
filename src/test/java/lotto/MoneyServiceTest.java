package lotto;

import lotto.domain.money.Money;
import lotto.domain.money.service.MoneyService;
import lotto.factory.InputFactory;
import lotto.global.config.AppConfig;
import lotto.global.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyServiceTest {

    MoneyService moneyService = new AppConfig().moneyService();

    @Nested
    @DisplayName("금액 입력 받기")
    class createMoney {
        @Test
        @DisplayName("입력 받은 금액이 올바른 금액이면 Money객체 생성")
        void success() {
            //given
            final String inputMoney = "2000";
            //when
            final Money money = moneyService.createMoney(inputMoney);
            //then
            Assertions.assertThat(money.getMoney()).isEqualTo(2000);
        }


        @Test
        @DisplayName("입력 받은 금액이 음수이면 예외 발생")
        void fail1() {
            //given
            final String inputMoney = "-2000";
            //when && then
            assertThatThrownBy(() -> moneyService.createMoney(inputMoney))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NEGATIVE_NUMBER);
        }

        @Test
        @DisplayName("입력 받은 금액이 천원단위가 아니면 예외 발생")
        void fail2() {
            //given
            final String inputMoney = "1200";
            //when && then
            assertThatThrownBy(() -> moneyService.createMoney(inputMoney))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NOT_IN_THOUSANDS_OF_NUMBER);
        }

        @Test
        @DisplayName("입력 받은 금액이 숫자가 아니면 예외 발생")
        void fail3() {
            //given
            final String inputMoney = "1000j";
            //when && then
            assertThatThrownBy(() -> moneyService.createMoney(inputMoney))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.IS_NOT_INTEGER);
        }
    }
}
