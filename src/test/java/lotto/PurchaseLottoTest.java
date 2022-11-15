package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.business.controller.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseLottoTest {
    @DisplayName("1000원 단위로 금액을 입력하면 로또를 구매할 수 있다.")
    @Test
    void 로또_구매() {
        Integer value = 100000;
        LottoGame lottoGame = new LottoGame();
        assertThatCode(() -> lottoGame.purchaseLotto(value)).doesNotThrowAnyException();
    }

    @DisplayName("음수를 입력할 경우 에러 출력 후 종료")
    @Test
    void 입력이_음수() {
        Integer value = -5000;
        LottoGame lottoGame = new LottoGame();
        assertThatThrownBy(() -> lottoGame.purchaseLotto(value)).isInstanceOf(IllegalArgumentException.class);
    }
}
