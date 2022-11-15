package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LottoIssuerTest {
    @DisplayName("금액에 맞는 로또를 발행하는지 검사.")
    @Test
    void purchaseLottosTest() {
        LottoIssuer lottoIssuer = new LottoIssuer();
        Assertions.assertThat(lottoIssuer.purchaseLottos(3000).getLottos().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource("invalidParameter")
    @DisplayName("잘못된 구매금액이 주어지면 예외.")
    void invalidPurchasePrice(int purchasePrice) {
        LottoIssuer issuer = new LottoIssuer();
        Assertions.assertThatThrownBy(() -> issuer.purchaseLottos(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidParameter() {
        return Stream.of(
                Arguments.of(2400),
                Arguments.of(-1),
                Arguments.of(0)
        );
    }
}
