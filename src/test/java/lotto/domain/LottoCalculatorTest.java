package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class LottoCalculatorTest {

    private LottoCalculator lottoCalculator = new LottoCalculator();
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winningLotto;
    private int bonusNumber;

    @BeforeEach
    void init() {
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9))); // 5등
        lottos.add(new Lotto(Arrays.asList(1, 3, 5, 7, 9, 11))); // 5등
    }

    @Test
    void 발행된_로또와_정답_로또를_비교하여_MAP에_등수와_당첨된_횟수를_저장한다(){
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))); // 3등
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))); // 2등

        Map<Rank, Integer> lottoResult = lottoCalculator.calculateResult(lottos, winningLotto, bonusNumber);

        Assertions.assertThat(lottoResult.get(Rank.FIFTH)).isEqualTo(2);
        Assertions.assertThat(lottoResult.get(Rank.THIRD)).isEqualTo(1);
        Assertions.assertThat(lottoResult.get(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    void 구매한_금액과_전체_수익을_통해_수익률을_계산한다() {
        int amount = 5000;
        lottoCalculator.calculateResult(lottos, winningLotto, bonusNumber);
        double profitRate = lottoCalculator.calculateProfitRate(amount);

        Assertions.assertThat(profitRate).isEqualTo(200.0f);
    }

    @Test
    void 구매한_로또와_정답_로또를_비교하여_맞는_개수를_계산한다() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = lottoCalculator.getClass().getDeclaredMethod("countMatchedNumber", Lotto.class, Lotto.class);
        method.setAccessible(true);

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 14, 15, 16));
        Lotto target = this.winningLotto;

        int resultCount1 = (int) method.invoke(lottoCalculator, lotto1, target);
        int resultCount2 = (int) method.invoke(lottoCalculator, lotto2, target);

        Assertions.assertThat(resultCount1).isEqualTo(6);
        Assertions.assertThat(resultCount2).isEqualTo(3);
    }
}