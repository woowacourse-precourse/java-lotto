package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 중복이 없어야함
 * 오름차순 정렬되어야 함
 * 잘못된 입력 exception
 */
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
    void lottoGenerator_SizeOfLottosIsEqualsToQuantity_True() {
        Assertions.assertThat(lottos.size()).isEqualTo(size);
    }

    @Test
    void lottoGenerator_LottosIsAscendingOrder_True() {
        for (Lotto lotto : lottos) {
            List<Integer> list = new ArrayList<>(lotto.get());
            for (int i = 0; i < 5; i++) {
                assertThat(list.get(i)).isLessThan(list.get(i + 1));
            }
        }
    }

}