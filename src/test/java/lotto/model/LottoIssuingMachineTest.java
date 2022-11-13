package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.LottoConstant.*;
import static org.assertj.core.api.Assertions.*;

class LottoIssuingMachineTest {

    private final LottoIssuingMachine issuingMachine = new LottoIssuingMachine();

    @BeforeEach
    void setUp() {
        issuingMachine.getLottos().clear();
    }

    @DisplayName("로또 구매 금액이 1,000원 미만일 때 예외가 발생한다.")
    @Test
    void issueLottosBySmallPurchaseMoney() {
        assertThatThrownBy(() -> issuingMachine.issue(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_PURCHASE_MONEY_MIN);
    }

    @DisplayName("로또 구매 금액이 1,000원 단위가 아닐 때 예외가 발생한다.")
    @Test
    void issueLottosByWrongUnitOfPurchaseMoney() {
        assertThatThrownBy(() -> issuingMachine.issue(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_PURCHASE_MONEY_UNIT);
    }

    @DisplayName("로또 구매 금액이 1,000원 단위일 때 (로또 구매 금액/1000)개의 로또가 발행된다.")
    @Test
    void issueLottosByPurchaseMoney() {
        //given
        int purchaseMoney = 5000;

        //when
        issuingMachine.issue(purchaseMoney);

        //then
        assertThat(issuingMachine.getNumberOfIssuedLottos()).isEqualTo(purchaseMoney / LOTTO_PRICE);
    }

    @DisplayName("발행된 로또들은 모두 서로 다르다.")
    @Test
    void issueLottosTest() {
        //given
        int purchaseMoney = 5000;

        //when
        issuingMachine.issue(purchaseMoney);
        List<Lotto> issuedLottos = issuingMachine.getLottos();

        //then
        for (Lotto issuedLotto : issuedLottos) {
            assertThat(issuedLottos.stream().filter(lotto -> lotto == issuedLotto).count())
                    .isEqualTo(1);
        }
    }
}
