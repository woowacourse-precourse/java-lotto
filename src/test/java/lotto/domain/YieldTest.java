package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class YieldTest {


    @DisplayName("수익률 비교")
    @Test
    void createYield() {
        assertThat(new Yield(10000, 8)).isEqualTo("총 수익률은 80%입니다.");
    }
}
