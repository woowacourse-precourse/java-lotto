package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StoreTest {

    @DisplayName("입력된 돈이 1000원으로 나누어 떨어지지 않으면 예외를 발생시킨다.")
    @Test
    void isThousandMultipleNumber() {
        int money = 1200;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Store.validate(money);
        });
    }

}