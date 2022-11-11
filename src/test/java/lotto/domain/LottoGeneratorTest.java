package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    LottoGenerator lottoGenerator;
    List<Lotto> lottos;
    int size = 8;

    @BeforeEach
    void Init_Before_Test() {
        lottoGenerator = new LottoGenerator(size);
        lottos = lottoGenerator.generateLottos();
    }

    @Test
    @DisplayName("수량만큼 로또가 생성되면 통과")
    void lottoGenerator_SizeOfLottosIsEqualsToQuantity_True() {
        Assertions.assertThat(lottos.size()).isEqualTo(size);
    }

    @Test
    @DisplayName("로또 번호가 오름차순이고 1, 45 사이면 통과")
    void lottoGenerator_LottosIsAscendingOrder_True() {
        for (Lotto lotto : lottos) {
            List<Integer> list = new ArrayList<>(lotto.get());
            for (int i = 0; i < 5; i++) {
                assertThat(list.get(i))
                        .isLessThan(list.get(i + 1))
                        .isBetween(1, 45);
            }
        }
    }

    @Test
    @DisplayName("로또 번호가 6개면 통과")
    void lottoGenerator_SizeOfLottoIs6_True() {

    }
}