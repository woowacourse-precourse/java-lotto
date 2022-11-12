package lotto.modelTest;

import lotto.model.Lotto;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    void 나머지가_있는_금액() {
        assertThatThrownBy(() -> new Money("1002"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천원_이하_금액() {
        assertThatThrownBy(() -> new Money("-982"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 알맞은_금액() {
        assertThatNoException().isThrownBy(() -> new Money("1000"));
    }
}
