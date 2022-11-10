package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLottoTest {

    @DisplayName("구매수량 입력시 숫자 이외 다른 것을 입력하면 예외가 발생한다.")
    @Test
    void purchaseLottoQtyCheckInput() {
        String input = "1,000";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new UserLotto(input));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Purchase Pay Isn't Consist Of Number.");

    }

    @DisplayName("구매수량 입력 시 1000원 단위로 입력하지 않을 시 예외가 발생한다.")
    @Test
    void purchaseLottoQtyCheckReminder() {
        String input = "150300";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new UserLotto(input));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Purchase Pay Reminder Isn't Zero.");
    }
}