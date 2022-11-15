package lotto.gameResult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyingLottoTest {
    @DisplayName("로또를 구입했을 때 제대로된 갯수를 생성하는지 테스트")
    @Test
    void lottoNumberTest() {
        BuyingLotto.lottoBundleGenerator("9000");

        assertThat(BuyingLotto.lottoBundle.size()).isEqualTo(9);
    }

    @DisplayName("로또를 구입했을 때 제대로된 메시지를 출력하는지 테스트")
    @Test
    void lottoBuyingMessage() {
        assertThat(BuyingLotto.orderNumber("9000")).contains("9개를 구매");
    }
}
