package lotto;

import lotto.Model.ErrorResponse;
import lotto.Model.Lotto;
import lotto.Model.LottoManager;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @BeforeEach
    void initializeManager(){
        LottoManager.initialize();
    }

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

    @DisplayName("사용자의 당첨금 번호 입력값에 오류가 없는 경우")
    @Test
    void validAppropriateWinningNumbers(){
        LottoManager.getWinningNumbers("1,2,3,4,5,6");
        assertThat(LottoManager.winnings.size())
                .isEqualTo(6);
        LottoManager.initialize();
    }

    @DisplayName("사용자의 당첨금 번호 입력값이 쉼표로 구분되어 있지 않은 경우 에러를 발생한다.")
    @Test
    void validWinningNumbers(){
        assertThatThrownBy(() -> LottoManager.getWinningNumbers("42 5 2 3 1 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.valueOf(ErrorResponse.INVALID_WINNING_NUMBERS));
        LottoManager.initialize();
    }

    @DisplayName("사용자의 당첨금 번호 입력 값이 1~45 사이의 숫자 값이 아닌 경우 에러를 발생한다.")
    @Test
    void validWiningNumberRange(){
        LottoManager m = new LottoManager();
        assertThatThrownBy(() -> m.getWinningNumbers("24,1,26,57,28,29"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.valueOf(ErrorResponse.INVALID_LOTTO_NUMBER_RANGE));
    }

    @DisplayName("사용자의 당첨금 번호가 6개가 입력되지 않은 경우 에러를 발생한다.")
    @Test
    void validWinningNumbersAmount(){
        assertThatThrownBy(() -> LottoManager.getWinningNumbers("1,2,3,4,5,6,35"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.valueOf(ErrorResponse.INVALID_WINNING_NUMBERS));
    }

    @DisplayName("사용자가 입력한 당첨금 번호에 중복이 있는 경우 에러를 발생한다.")
    @Test
    void validWinningNumbersDuplication() {
        assertThatThrownBy(() -> LottoManager.getWinningNumbers("1,2,3,4,5,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.valueOf(ErrorResponse.INVALID_WINNING_UNIQUE_NUMBERS));
    }

    @DisplayName("사용자가 입력한 보너스 번호가 당첨 번호와 중복된 경우 에러를 발생한다.")
    @Test
    void validBonusNumberDuplication(){
        LottoManager.getWinningNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> LottoManager.getBonusNumber("5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.valueOf(ErrorResponse.INVALID_BONUS_UNIQUE_NUMBER));
    }

    @DisplayName("사용자가 입력한 보너스 번호가 1~45 사이의 정수값이 아니라면 에러를 발생한다.")
    @Test
    void validBonusNumberRange(){
        assertThatThrownBy(() -> LottoManager.getBonusNumber("53"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.valueOf(ErrorResponse.INVALID_LOTTO_NUMBER_RANGE));
    }
}
