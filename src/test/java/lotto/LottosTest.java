package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void lottosInit() {
        lottos = new Lottos(3);
    }

    @Test
    public void lottosValidTest() {
        for(Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(Lotto.isValidSize(numbers)).isTrue();
            assertThat(Lotto.isDuplicated(numbers)).isFalse();
            assertThat(Lotto.isNotValidRange(numbers)).isFalse();
        }
    }
}
