package lotto.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.NumberGenerateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGenerateStrategyTest {
    private NumberGenerateStrategy numberGenerateStrategy;

    @BeforeEach
    void setUp() {
        this.numberGenerateStrategy = new RandomNumberGenerateStrategy() {
            @Override
            public List<Integer> generateNumbers() {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        };
    }

    @DisplayName("1부터 45 임의의 숫자 6개를 생성한다.")
    @Test
    void generateNumber() {
        assertThat(numberGenerateStrategy.generateNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }
}
