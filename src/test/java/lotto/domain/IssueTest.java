package lotto.domain;

import lotto.Lotto;
import lotto.domain.impl.IssueImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

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

    @ParameterizedTest
    @DisplayName("발행 매수는 [구입 금액 / 1000]이다.")
    @CsvSource({"10000,10", "1000,1", "5000,5"})
    void issueLottoCount(int amount, int expected) {
        List<Lotto> lottos = issue.createLotto(amount);

        assertThat(lottos.size()).isEqualTo(expected);
    }
}