package lotto.domain;

import lotto.domain.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPurchaseTest {

    @Test
    @DisplayName("로또 금액을 입력받으면 몇 장을 구매했는지 리턴한다.")
    void 로또_구매_장수_테스트() throws Exception {
        //given
        LottoPurchase lottoPurchase = new LottoPurchase();
        Method method = lottoPurchase.getClass().getDeclaredMethod("getPurchaseCount", int.class);
        method.setAccessible(true);

        //when
        int purchaseAmount = 5000;

        //then
        int purchaseCount = (int) method.invoke(lottoPurchase, purchaseAmount);
        assertThat(purchaseCount).isEqualTo(5);
    }
}