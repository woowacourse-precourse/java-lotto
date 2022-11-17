package lotto;

import java.util.HashMap;
import java.util.Map;
import lotto.Model.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    private Money money = new Money();
    private Map<String, Integer> result = new HashMap<>();

    @BeforeEach
    void init() {
        result.put("3", 1);
        result.put("5B", 1);
    }

    @Test
    void 상금_계산_테스트() {
        money.calculrateReturnRate(result);
        assertThat(money.getPrizeMoney()).isEqualTo(30_005_000L);
    }
}
