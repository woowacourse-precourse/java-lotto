package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.service.LottoService;
import lotto.system.SystemValid;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("사용자 금액이 로또금액으로 나누어지지 떨어지지 않는 다면 예외가 발생한다.")
    @Test
    void createdLottoServiceByMoneyDivideLottoPrice() {
        assertThatThrownBy(() -> lottoService.buy(2300))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 금액 0원이라면 예외가 발생한다.")
    @Test
    void createdLottoServiceByMoneyZero() {
        assertThatThrownBy(() -> lottoService.buy(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 입력 금액이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createdSystemValidByValidateNumber(){
        assertThatThrownBy(() -> SystemValid.validateForNumber("1000asw"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
