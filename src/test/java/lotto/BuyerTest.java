package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BuyerTest {
    private static Buyer buyer = new Buyer();

    @DisplayName("1000 단위가 아니다")
    @Test
    void 단위_테스트() {
        assertThatThrownBy(() -> {
            buyer.countCalculation(1100);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("공백을 입력했을 때")
    @Test
    void 공백_테스트() {
        assertThrows(IllegalArgumentException.class,
                () -> buyer.setListOfLotto(""));
    }
}