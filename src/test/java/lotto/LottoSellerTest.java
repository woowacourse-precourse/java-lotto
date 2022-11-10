package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

class LottoSellerTest {
    final LottoSeller lottoSeller = new LottoSeller();

    @DisplayName("숫자가 아닌 금액을 입력할 경우 예외가 발생한다.")
    @Test
    void inputStringForPrice() {
        String input = "200a";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Assertions.assertThatThrownBy(() -> lottoSeller.receivePurchasePrice())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 금액을 입력하면 정상적으로 동작한다.")
    @Test
    void inputValidPrice() {
        String input = "20000";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        int price = lottoSeller.receivePurchasePrice();

        Assertions.assertThat(price).isEqualTo(20000);
    }

    @DisplayName("중복된 당첨번호를 입력하면 예외가 발생한다.")
    @Test
    void inputWinningNumberByDuplicatedNumber() {
        String input = "1,1,2,3,4,5";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Assertions.assertThatThrownBy(() -> new Lotto(lottoSeller.receiveWinningNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 당첨번호를 입력하면 예외가 발생한다.")
    @Test
    void inputStringForWinningNumber() {
        String input = "1,1,2,3,a,5";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Assertions.assertThatThrownBy(() -> lottoSeller.receiveWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개가 아닌 당첨번호를 입력하면 예외가 발생한다.")
    @Test
    void inputWinningNumberBySizeOver() {
        String input = "1,9,8,7,6,5,4";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Assertions.assertThatThrownBy(() -> new Lotto(lottoSeller.receiveWinningNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 당첨번호를 입력하면 정상적으로 동작한다.")
    @Test
    void inputValidWinningNumber() {
        String input = "15,16,20,45,11,9";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        List<Integer> winningNumbers = lottoSeller.receiveWinningNumbers();

        Assertions.assertThat(winningNumbers)
                .isEqualTo(Arrays.asList(15, 16, 20, 45, 11, 9));
    }

    @DisplayName("숫자가 아닌 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void inputStringForBonusNumber() {
        String input = "a";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Assertions.assertThatThrownBy(() -> lottoSeller.receiveBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void inputBonusNumberOverRange() {
        String input = "47";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Assertions.assertThatThrownBy(() -> lottoSeller.receiveBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 보너스 번호를 입력하면 정상적으로 동작한다.")
    @Test
    void inputValidBonusNumber() {
        String input = "30";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        int number = lottoSeller.receiveBonusNumber();

        Assertions.assertThat(number).isEqualTo(30);
    }
}