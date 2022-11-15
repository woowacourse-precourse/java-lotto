package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호가 1보다 작거나 45보다 큰 경우 예외가 발생한다.")
    @Test
    void createLottoByRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구매한 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void createPurchaseByDivided() {
        assertThatThrownBy(() -> new LottoPurchase("1230"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구매한 금액이 1000원보다 작을 경우 예외가 발생한다.")
    @Test
    void createPurchaseByMinimum() {
        assertThatThrownBy(() -> new LottoPurchase("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구매한 금액이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createPurchaseByNumber() {
        assertThatThrownBy(() -> new LottoPurchase("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구매한 금액에 따른 티켓 개수가 맞는지 확인한다.")
    @Test
    void checkPurchaseByTicketNumber() {
        LottoPurchase lottopurchase = new LottoPurchase("8000");
        lottopurchase.calculateTicketCount();
        Assertions.assertEquals(lottopurchase.calculateTicketCount(),8);
    }
    @DisplayName("구매한 금액과 당첨금의 마진률이 맞는지 확인한다.")
    @Test
    void checkPurchaseByMargin() {
        LottoPurchase lottopurchase = new LottoPurchase("8000");
        Assertions.assertEquals(lottopurchase.calculateProfit(5000),62.5);
    }
}
