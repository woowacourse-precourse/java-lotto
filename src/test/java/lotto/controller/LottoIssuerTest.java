package lotto.controller;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class LottoIssuerTest {
    @DisplayName("1부터 45사이의 중복되지 않는 숫자 6개를 골라 로또를 생성한 경우 예외가 발생하지 않는다")
    @Test
    void issueCorrectLotto() {
        assertThatNoException()
                .isThrownBy(() -> LottoIssuer.issue());
    }

    @DisplayName("로또 구매 수량만큼의 로또를 발행한다")
    @Test
    void issueLottoByCorrectQuantity() {
        List<Lotto> lotteries = LottoIssuer.issue(14000);
        assertThat(lotteries.size()).isEqualTo(14);
    }
}
