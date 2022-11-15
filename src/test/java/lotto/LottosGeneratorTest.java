package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosGeneratorTest {

    @DisplayName("로또 구매 갯수만큼 로또를 생성한다.")
    @Test
    void createLottos() {
        // given
        int purchaseAmount = 8_000;
        Quantity quantity = new Quantity(purchaseAmount);

        // when
        LottosGenerator lottosGenerator = new LottosGenerator();
        List<Lotto> lottos = lottosGenerator.createLottos(quantity);

        // expected
        assertThat(lottos.size()).isEqualTo(quantity.getNumber());
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers.size()).isEqualTo(6);
            assertThat(numbers.stream().distinct().count()).isEqualTo(6);
            assertThat(numbers.stream().allMatch(number -> 1 <= number && number <= 45)).isTrue();
        }
    }
}