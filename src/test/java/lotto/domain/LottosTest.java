package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    void generateLottos_구매한_수량에_맞게_총_로또_수가_잘_생성되는지_테스트() {
        //given
        int lottoCount = 8;
        List<Lotto> lottos = new ArrayList<>();
        //when
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        //then
        assertThat(lottos.size())
                  .isEqualTo(lottoCount);
    }

    @Test
    void checkLottos_구매한_로또들이_정렬되어서_반환되는지_테스트() {
        //given
        List<Lotto> lottos = new ArrayList<>(List.of(new Lotto(List.of(6, 5, 4, 3, 2, 1))));
        Lottos purchasedLottos = new Lottos();
        //when
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumbers);
            purchasedLottos.getLottos().add(new Lotto(sortedNumbers));
        }
        //then
        for (int i = 0; i < 6; i++) {
            assertThat(purchasedLottos.getLottos()
                                      .get(0)
                                      .getNumbers()
                                      .get(i)).isEqualTo(i+1);
        }

    }
}