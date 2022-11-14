package lotto.domain;

import lotto.Lotto;
import lotto.domain.impl.IssueImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Constants.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IssueTest {

    private final Issue issue = new IssueImpl();

    @Test
    @DisplayName("구입 금액이 1,000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void amountException() {
        assertThatThrownBy(() -> issue.createLotto(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("발행 매수는 [구입 금액 / 1000]이다.")
    void issueLottoCount() {
        int amount = 10000;

        List<Lotto> lottos = issue.createLotto(amount);

        assertThat(lottos.size()).isEqualTo(amount / LOTTO_PRICE);
    }
}