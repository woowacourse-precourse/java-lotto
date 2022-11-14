package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @DisplayName("구매한 수량에 맞게 총 로또 수가 잘 생성되는지 테스트")
    @Test
    void generateLottos() {
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

    @DisplayName("구매한 로또들이 정렬되어서 반환되는지 테스트")
    @Test
    void checkLottos() {
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