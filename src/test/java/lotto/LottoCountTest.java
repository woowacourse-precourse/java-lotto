package lotto;

import lotto.model.LottoCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoCountTest {
    @DisplayName("로또 구매 금액이 1000원 단위가 아닐때 예외 발생 확인.")
    @Test
    void userAmountNotThousand() {
        assertThatThrownBy(() -> new LottoCount(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 구매 금액이 0원일때 예외 발생 확인.")
    @Test
    void userAmountZero() {
        assertThatThrownBy(() -> new LottoCount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액만큼 로또 발행 확인.")
    @Test
    void userAmountToLottoTicketsCount() {
        LottoCount lottoCount = new LottoCount(20000);
        assertThat(lottoCount.calculateLottoCount()).isEqualTo(20);
    }
}
