package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PurchasedLottoTest {

    @DisplayName("로또 구입 금액이 정상인 경우")
    @Test
    void 구입금액이_정상인_경우() {
        assertThat(new PurchasedLotto(14000));
    }

    @DisplayName("로또 구입 금액이 1000의 배수가 아닌 경우")
    @Test
    void 구입금액이_1000의_배수가_아닌_경우() {
        assertThatThrownBy(() -> new PurchasedLotto(1400))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 음수인 경우")
    @Test
    void 구입금액이_음수인_경우() {
        assertThatThrownBy(() -> new PurchasedLotto(-3000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}