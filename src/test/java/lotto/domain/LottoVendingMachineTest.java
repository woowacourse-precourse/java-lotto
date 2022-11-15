package lotto.domain;

import lotto.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("1000의 양의 배수만큼 돈을 지불하지 않으면 예외가 발생한다")
class LottoVendingMachineTest {

    AppConfig appConfig = new AppConfig();
    LottoVendingMachine lottoVendingMachine = appConfig.createLottoVendingMachine();

    @DisplayName("정상 입력")
    @Test
    void inputNomalCase() {
        assertThat(lottoVendingMachine.generateLottos(4000).size()).isEqualTo(4);

    }

    @DisplayName("1000이상이나 배수가 아닌 경우")
    @Test
    void inputMoneyByNotPositiveMultipleOf1000() {
        assertThatThrownBy(() -> lottoVendingMachine.generateLottos(1980))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000미만인 경우")
    @Test
    void inputMoneyByNotPositiveMultipleOf1000_UnderCase() {
        assertThatThrownBy(() -> lottoVendingMachine.generateLottos(190))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수인 경우")
    @Test
    void inputMoneyByNotPositiveMultipleOf1000_NagetiveCase() {
        assertThatThrownBy(() -> lottoVendingMachine.generateLottos(-1992))
                .isInstanceOf(IllegalArgumentException.class);
    }

}