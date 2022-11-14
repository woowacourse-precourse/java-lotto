package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @ParameterizedTest
    @ValueSource(ints = {500, 0, -100, 999})
    void issueLottosByMinPurchaseMoney(int purchaseMoney) {
        assertThatThrownBy(() -> issuingMachine.issue(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_PURCHASE_MONEY_MIN);
    }

    @DisplayName("로또 구매 금액이 100,000원 초과일 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {150000, 100001, 1000000})
    void issueLottosByMaxPurchaseMoney(int purchaseMoney) {
        assertThatThrownBy(() -> issuingMachine.issue(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_PURCHASE_MONEY_MAX);
    }

    @DisplayName("로또 구매 금액이 1,000원 단위가 아닐 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1500, 1001, 19003})
    void issueLottosByWrongUnitOfPurchaseMoney(int purchaseMoney) {
        assertThatThrownBy(() -> issuingMachine.issue(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_PURCHASE_MONEY_UNIT);
    }

    @DisplayName("로또 구매 금액이 1,000원 단위일 때 (로또 구매 금액/1000)개의 로또가 발행된다.")
    @ParameterizedTest
    @ValueSource(ints = {5000, 8000, 10000})
    void issueLottosByPurchaseMoney(int purchaseMoney) {
        issuingMachine.issue(purchaseMoney);
        assertThat(issuingMachine.getNumberOfIssuedLottos()).isEqualTo(purchaseMoney / LOTTO_PRICE);
    }

    @DisplayName("발행된 로또들은 모두 서로 다르다.")
    @ParameterizedTest
    @ValueSource(ints = {5000, 8000, 10000})
    void issueLottosTest(int purchaseMoney) {
        issuingMachine.issue(purchaseMoney);
        List<Lotto> issuedLottos = issuingMachine.getLottos();

        for (Lotto issuedLotto : issuedLottos) {
            assertThat(issuedLottos.stream().filter(lotto -> lotto == issuedLotto).count())
                    .isEqualTo(1);
        }
    }
}
