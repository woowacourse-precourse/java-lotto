package lotto.domain;

import lotto.Lotto;
import lotto.domain.impl.IssueImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static lotto.message.ExceptionMessage.AMOUNT_EXCEPTION;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IssueTest {

    private final Issue issue = new IssueImpl();

    @ParameterizedTest
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @CsvSource({"1100","0", "500"})
    void amountException(int amount) {
        assertThatThrownBy(() -> issue.createLottos(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AMOUNT_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("발행 매수는 [구입 금액 / 1000]이다.")
    @CsvSource({"10000,10", "1000,1", "5000,5"})
    void issueLottoCount(int amount, int expected) {
        List<Lotto> lottos = issue.createLottos(amount);

        assertThat(lottos.size()).isEqualTo(expected);
    }
}