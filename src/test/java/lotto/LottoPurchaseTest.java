package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import lotto.domain.LottoPurchase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseTest {

    @DisplayName("로또 구입 시 숫자를 입력받지 않으면 익셉션을 발생한다.")
    @Test
    void casePurchaseInputNotInteger(){
        assertThatThrownBy(() -> new LottoPurchase("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 시 음수 값을 입력 받으면 익셉션을 발생한다.")
    @Test
    void casePurchaseInputNegative(){
        assertThatThrownBy(() -> new LottoPurchase("-2000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 시 로또 가격 단위로 받지 않을 시 오류를 발생한다.")
    @Test
    void casePurchaseInputNotCorrectPriceUnit(){
        assertThatThrownBy(() -> new LottoPurchase("1800"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
