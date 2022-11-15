package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoIssuerTest {
    @DisplayName("금액에 맞는 로또를 발행하는지 검사.")
    @Test
    void purchaseLottosTest() {
        Assertions.assertThat(LottoIssuer.purchaseLottos(3000).getLottos().size()).isEqualTo(3);
    }
}
