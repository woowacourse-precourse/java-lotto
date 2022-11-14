package lotto;

import domain.LottoIssue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class domainTest {
    @DisplayName("금액에 맞게 로또 발행")
    @Test
    void 금액에_맞는_로또발행_테스트() {
        assertThat(LottoIssue.issueLotto("8000") ).isEqualTo(8);
    }

    @DisplayName("금액입력 예외처리")
    @Test
    void 금액입력_예외처리_테스트() {
        assertThatThrownBy(() ->LottoIssue.handleInputMoneyException("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
