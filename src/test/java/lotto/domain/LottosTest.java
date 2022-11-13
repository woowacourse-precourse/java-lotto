package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
}