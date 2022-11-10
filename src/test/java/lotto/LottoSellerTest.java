package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class LottoSellerTest {
    final LottoSeller lottoSeller = new LottoSeller();

    @DisplayName("숫자가 아닌 금액을 입력할 경우 예외가 발생한다.")
    @Test
    void inputStringForPrice(){
        String input = "200a";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Assertions.assertThatThrownBy(()-> lottoSeller.receivePurchasePrice())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 금액을 입력하면 정상적으로 동작한다.")
    @Test
    void inputValidPrice(){
        String input = "20000";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        int price = lottoSeller.receivePurchasePrice();

        Assertions.assertThat(price).isEqualTo(20000);
    }
}