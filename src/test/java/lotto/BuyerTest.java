package lotto;

import lotto.Model.Buyer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BuyerTest {

    @Test
    void 금액_정상입력_테스트() {
        assertThat(new Buyer("8000").getBuyerMoney()).isEqualTo(8000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"8500", "0","1002"})
    void 천원_단위가_아니거나_0을_입력했을때_예외처리(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Buyer(input);
        });
    }


}
