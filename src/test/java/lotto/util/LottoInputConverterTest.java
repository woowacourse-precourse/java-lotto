package lotto.util;

import lotto.util.converter.LottoInputConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputConverterTest {

    public LottoInputConverter lottoInputConverter = new LottoInputConverter();

    @DisplayName("사용자가 로또 구매 가격 입력시 null 을 입력할 경우 예외가 발생한다.")
    @Test
    void userInputPurchaseCostNull() {
        assertThatThrownBy(() -> lottoInputConverter.userLottoPurchaseCostToInt(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 로또 구매 가격 입력시 숫자를 입력하지 않은 경우 예외가 발생한다.")
    @Test
    void userInputPurchaseCostNotNumber() {
        assertThatThrownBy(() -> lottoInputConverter.userLottoPurchaseCostToInt("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 로또 구매 가격 입력시 음수를 입력하는 경우 예외가 발생한다.")
    @Test
    void userInputPurchaseCostUnder0() {
        assertThatThrownBy(() -> lottoInputConverter.userLottoPurchaseCostToInt("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 당첨 로또 번호 입력시 null 을 입력할 경우 예외가 발생한다.")
    @Test
    void userInputWinningLottoNumberNull() {
        assertThatThrownBy(() -> lottoInputConverter.winningLottoNumberToList(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 당첨 로또 번호 입력시 잘못된 포맷을 입력할 경우 예외가 발생한다.")
    @Test
    void userInputWinningLottoNumberUnfittedFormat() {
        assertThatThrownBy(() -> lottoInputConverter.winningLottoNumberToList("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 당첨 로또 번호 입력시 6자리 보다 많은 숫자를 입력할 경우 예외가 발생한다.")
    @Test
    void userInputWinningLottoNumberMoreThan6Numbers() {
        assertThatThrownBy(() -> lottoInputConverter.winningLottoNumberToList("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 보너스 번호 입력시 숫자가 아닌 값을 입력할 경우 예외가 발생한다.")
    @Test
    void userInputBonusNumberNotNumber() {
        assertThatThrownBy(() -> lottoInputConverter.bonusLottoNumberToInt("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}