package lotto.service;

import java.util.EnumMap;
import lotto.model.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class CalculateTest {

    private final Calculate calculate = new Calculate();

    @ParameterizedTest
    @EnumSource(Prize.class)
    void 당첨금_확인(Prize prize) {
        double yield = calculate.yield(1_000, new EnumMap<>(Prize.class) {{
            put(prize, 1);
        }});

        Assertions.assertThat(yield).isEqualTo(prize.getMoney() / (double) 10);
    }

}