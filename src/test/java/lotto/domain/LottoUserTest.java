package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.util.ConstValue.LottoConst.LOTTO_BASIC_COST;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoUserTest {

    @DisplayName("로또 구매 최소 비용보다 적은 돈으로 로또 구매시 예외가 발생한다.")
    @Test
    void lottoPurchaseMinimumCostTest() {
        // given
        int purchaseCost = 999;

        // then
        assertThatThrownBy(() -> new LottoUser(purchaseCost))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 단위가 맞지 않는 경우 예외가 발생한다.")
    @Test
    void lottoPurchaseUnitErrorTest() {
        // given
        int purchaseCost = 1001;

        // then
        assertThatThrownBy(() -> new LottoUser(purchaseCost))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 값을 입력 받으면 유저의 로또 구매가 정상적으로 이루어진다.")
    @Test
    void lottoPurchaseWithRightValueTest() {
        // given
        final int lottoCount = 15;
        int purchaseCost = lottoCount * LOTTO_BASIC_COST;

        // when
        LottoUser lottoUser = new LottoUser(purchaseCost);

        // then
        assertEquals(lottoCount, lottoUser.getRandomLottos().size());
    }
}
