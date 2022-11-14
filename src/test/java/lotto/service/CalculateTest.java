package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

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