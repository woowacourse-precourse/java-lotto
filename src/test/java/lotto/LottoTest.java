package lotto;

import lotto.Model.ErrorResponse;
import lotto.Model.Lotto;
import lotto.Model.LottoManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자에게 입력 받은 금액이 정수가 아닌 경우 예외가 발생한다.")
    @Test
    void validInputPriceIfInteger(){
        assertThatThrownBy(() -> LottoManager.getUserMoney("money14000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.valueOf(ErrorResponse.INVALID_MONEY));
    }

    @DisplayName("사용자에게 입력 받은 금액이 1000원으로 나누어지지 않는 경우 예외가 발생한다.")
    @Test
    void validInputLottoPurchasePrice(){
        assertThatThrownBy(() -> LottoManager.getUserMoney("14500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.valueOf(ErrorResponse.INVALID_LOTTO_PURCHASE_PRICE));
    }

    @DisplayName("사용자게에 입력 받은 금액대로 토또 티켓 수량을 올바르게 계산하는지 확인한다.")
    @Test
    void validLottoTicketNumber(){
        List<String> purchases = new ArrayList<>((List.of("24000", "23000", "53000", "6000", "12000", "2499000")));
        for (String purchase: purchases) {
            LottoManager.getUserMoney(purchase);
            LottoManager.getIssuedLotto();
            assertThat(LottoManager.getTicketNumber())
                    .isEqualTo(Integer.parseInt(purchase) / 1000);
        }
    }

    @DisplayName("로또 티켓 수량에 따라 로또 번호를 발행했는지 확인한다.")
    @Test
    void validIssuedLotto(){
        List<String> purchases = new ArrayList<>((List.of("24000", "23000", "53000", "6000", "12000", "1000")));
        for (String purchase: purchases) {
            LottoManager manager = new LottoManager();
            manager.getUserMoney(purchase);
            manager.issue();
            assertThat(manager.userLotto.size())
                    .isEqualTo(Integer.parseInt(purchase) / 1000);
            manager.initialize();
        }
    }
}
