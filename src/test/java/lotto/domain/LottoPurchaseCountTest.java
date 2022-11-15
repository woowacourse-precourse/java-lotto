package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseCountTest {

    LottoPurchaseCount lottoPurchaseCount;

    @BeforeEach
    void init() {
        lottoPurchaseCount = new LottoPurchaseCount();
    }

    @DisplayName("로또 개수 확인 테스트")
    @Test
    void checkLottoCount() {
        int count = lottoPurchaseCount.getLottoPurchaseCount(5000);
        assertThat(count).isSameAs(5);
    }

    @DisplayName("로또 금액 입력 예외 테스트")
    @Test
    void checkInputLottoMoneyException() {
        assertThatThrownBy(() -> lottoPurchaseCount.getLottoPurchaseCount(5500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위로 입력해주세요.");
    }
}