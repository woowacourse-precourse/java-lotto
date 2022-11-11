package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchaseTest {
    @Test
    void 올바른_로또_금액_입력() {
        Purchase issueCount = new Purchase("8000");
        Assertions.assertThat(issueCount.get()).isEqualTo(8);
    }
}