package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoContainerTest {

    @Test
    void 수익률_정상_테스트() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45))
        );
        LottoContainer lottoContainer = new LottoContainer(lottos);
        List<Integer> normalNumbers = Arrays.asList(1,2,3,4,5,6);
        int bonusNumber = 10;
        Map<LottoResult, Integer> match = lottoContainer.matchAll(normalNumbers, bonusNumber);

        Assertions.assertThat(lottoContainer.getRate(match)).isEqualTo(2750.0);
    }

}
