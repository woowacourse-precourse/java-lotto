package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ControlLottoGameTest{

    @DisplayName("구입 금액을 입력했을 때, 구매할 로또 수량으로 정상 변환 되는지 보여준다.")
    @Test
    void quantityConversionTest() {
        ControlLottoGame control = new ControlLottoGame();
        int input = 8000;
        int output = 8;
        assertThat(control.priceToQuantity(input)).isEqualTo(output);
    }

    @DisplayName("입력된 값이 숫자가 맞는지 확인한다.")
    @Test
    void numberValidationTest() {
        ControlLottoGame control = new ControlLottoGame();
        String input = "8000";
        assertThat(control.validateNumber(input)).isEqualTo(true);
    }

    @DisplayName("입력된 당첨 번호가 리스트로 입력 되는지 확인한다.")
    @Test
    void inputWinningNumbersTest() {
        ControlLottoGame control = new ControlLottoGame();
        String input = "1,2,3,4,5,6";
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);
        assertThat(control.inputToWinningNumbers(input)).isEqualTo(result);
    }

    @DisplayName("당첨 내역에 맞게 수익률이 계산되는지 확인한다.")
    @Test
    void earningRateTest() {
        ControlLottoGame control = new ControlLottoGame();
        List<Integer> input = List.of(1, 0, 0, 0, 0);
        int quantity = 8;
        double rate = 62.5;
        assertThat(control.calculateEarningRate(input, quantity)).isEqualTo(rate);
    }
}
