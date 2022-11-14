package lotto;

import lotto.domain.lotto.BonusBall;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.service.LottoService;
import lotto.domain.money.Money;
import lotto.factory.InputFactory;
import lotto.global.config.AppConfig;
import lotto.global.message.ErrorMessage;
import lotto.global.utils.convert.ConvertUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {

    LottoService lottoService = new AppConfig().lottoService();

    @Nested
    @DisplayName("금액에 맞는 로또 구매하기")
    class buyLottos {
        @Test
        @DisplayName("2000원 어치의 로또를 구매하면 6개의 숫자가 포함된 로또 2개가 생성된다.")
        void success()  {
            //given
            final Money money = Money.create(2000);
            //when
            final Lottos lottos = lottoService.buyLottos(money);
            //then
            assertThat(lottos.size()).isEqualTo(2);
            assertThat(lottos.getLottos().get(1).getNumbers().size()).isEqualTo(6);
        }
    }

    @Nested
    @DisplayName("당첨 번호 입력 받기")
    class requestWinningNumbers {

        @Test
        @DisplayName("1 ~ 45 사이의 숫자를 구분자 , 를 이용해 6개를 입력햿다면 성공한다.")
        void success() {
            //given
            InputFactory.inputNumber("1,2,3,4,5,6");
            //when
            final Lotto lotto = lottoService.requestWinningNumbers();
            //then
            assertThat(lotto.getNumbers().size()).isEqualTo(6);
        }

        @Test
        @DisplayName("당첨 번호 구분자를 , 로 사용하지 않았다면 예외가 발생한다.")
        void fail1() {
            //given
            InputFactory.inputNumber("1.2.3.4.5.6");
            //when && then
            assertThatThrownBy(() -> lottoService.requestWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WINNING_NUMBERS);
        }

        @Test
        @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
        void fail2() {
            //given
            InputFactory.inputNumber("1,2,3,1000j,4,5");
            //when && then
            assertThatThrownBy(() -> lottoService.requestWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WINNING_NUMBERS);
        }

        @Test
        @DisplayName("당첨 번호가 공백이면 예외가 발생한다.")
        void fail3() {
            //given
            InputFactory.inputNumber(" ");
            //when && then
            assertThatThrownBy(() -> lottoService.requestWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WINNING_NUMBERS);
        }
    }

    @Nested
    @DisplayName("보너스 번호 입력 받기")
    class requestBonusNumber {
        @Test
        @DisplayName("1 ~ 45 사이의 숫자를 입력받으면 성공한다.")
        void success() {
            //given
            InputFactory.inputNumber("7");
            //when
            final BonusBall bonusBall = lottoService.requestBonusNumber();
            //then
            assertThat(bonusBall.getNumber()).isEqualTo(7);
        }

        @Test
        @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
        void fail1() {
            //given
            InputFactory.inputNumber("100j");
            //when && then
            assertThatThrownBy(() -> lottoService.requestBonusNumber())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.IS_NOT_INTEGER);
        }

        @Test
        @DisplayName("보너스 번호가 공백이면 예외가 발생한다.")
        void fail2() {
            //given
            InputFactory.inputNumber(" ");
            //when && then
            assertThatThrownBy(() -> lottoService.requestBonusNumber())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NOT_INPUT_NUMBER);
        }

        @Test
        @DisplayName("1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
        void fail3() {
            //given
            InputFactory.inputNumber("46");
            //when && then
            assertThatThrownBy(() -> lottoService.requestBonusNumber())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_RANGE);
        }
    }

}
