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
        lottos = new Lottos(3, Application.userIputStringToLotto("1,2,3,4,5,6"), 7);
    }

    @Test
    public void createdLottosValidTest() {
        for(Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(Lotto.isValidSize(numbers)).isTrue();
            assertThat(Lotto.isDuplicated(numbers)).isFalse();
            assertThat(Lotto.isNotValidRange(numbers)).isFalse();
        }
    }

    @Test
    public  void createdWinningLottoTest() {
        assertThatThrownBy(() -> Application.userIputStringToLotto("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(lottos.getBonusNum()).isEqualTo(7);
    }
}
