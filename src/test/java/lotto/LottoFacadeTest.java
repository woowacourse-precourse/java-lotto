package lotto;

import lotto.application.LottoFacade;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.factory.InputFactory;
import lotto.global.config.AppConfig;
import lotto.global.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoFacadeTest {

    LottoFacade lottoFacade = new AppConfig().lottoFacade();

    @Nested
    @DisplayName("금액 입력 받기")
    class createMoney {
        @Test
        @DisplayName("입력 받은 금액이 올바른 금액이면 Money객체 생성")
        void success() {
            //when
            final Money money = Money.create(2000);
            //then
            assertThat(money.getMoney()).isEqualTo(2000);
        }

        @Test
        @DisplayName("입력 받은 금액이 음수이면 예외 발생")
        void fail1() {
            //when && then
            assertThatThrownBy(() -> Money.create(-2000))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NEGATIVE_NUMBER);
        }

        @Test
        @DisplayName("입력 받은 금액이 천원단위가 아니면 예외 발생")
        void fail2() {
            //when && then
            assertThatThrownBy(() -> Money.create(1234))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NOT_IN_THOUSANDS_OF_NUMBER);
        }

        @Test
        @DisplayName("입력 받은 금액이 숫자가 아니면 예외 발생")
        void fail3() {
            //given
            InputFactory.inputNumber("1000j");

            //when && then
            assertThatThrownBy(() -> lottoFacade.createMoney())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.IS_NOT_INTEGER);
        }
    }

    @Nested
    @DisplayName("금액에 맞는 로또 구매하기")
    class buyLottos {
        @Test
        @DisplayName("2000원 어치의 로또를 구매하면 6개의 숫자가 포함된 로또 2개가 생성된다.")
        void success()  {
            //given
            final Money money = Money.create(2000);
            //when
            final Lottos lottos = lottoFacade.buyLottos(money);
            //then
            assertThat(lottos.size()).isEqualTo(2);
            assertThat(lottos.getLottos().get(1).getNumbers().size()).isEqualTo(6);
        }
    }
}
