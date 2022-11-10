package lotto.domain.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.UserLotto;
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

    @Test
    void purchaseLottoCheckQTY() {
        String input = "15000";

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        assertThat(new UserLotto(input).getUserLotto().size()).isEqualTo(lottos.size());
    }
}