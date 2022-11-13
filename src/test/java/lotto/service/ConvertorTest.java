package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ConvertorTest {

    @DisplayName("구입금액이 1,000원으로 나누어 떨어지지 않는 경우")
    @Test
    void getQuantityByWrongUnit() {
        //then
        assertThatThrownBy(() -> Convertor.getQuantity("1111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1,000원으로 나누어 떨어지지 않는 경우")
    @Test
    void getQuantityByNotNumber() {
        //then
        assertThatThrownBy(() -> Convertor.getQuantity("100a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
