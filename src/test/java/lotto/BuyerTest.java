package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {

    @DisplayName("구입 금액이 숫자가 아닐 시 예외 발생")
    @Test
    void inputBuyLottoMoney() {
        assertThatThrownBy(() -> new Buyer().va)
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void calculateLotteryNum() {
    }


    @Test
    void printBuyLotto() {
    }
}