package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    LottoGenerator lottoGenerator;
    List<Lotto> lottos;
    int money = 8000;
    int quantity = money / 1000;

    @BeforeEach
    void testInit() {
        lottoGenerator = new LottoGenerator(money);
        lottos = lottoGenerator.generateLottos();
    }

    @Test
    @DisplayName("생성되는 로또의 갯수는 money / 1000 이다.")
    void numberOfLottosEqualsToQuantity() {
        assertThat(lottos.size()).isEqualTo(quantity);
    }

    @Test
    @DisplayName("로또 번호는 오름차순이고 1과 45 사이의 숫자이다.")
    void createLottosInAscendingOrderOfNumbersFrom1To45() {
        for (Lotto lotto : lottos) {
            List<Integer> list = new ArrayList<>(lotto.get());
            for (int i = 0; i < 5; i++) {
                assertThat(list.get(i))
                        .isLessThan(list.get(i + 1))
                        .isBetween(1, 45);
            }
        }
    }
}