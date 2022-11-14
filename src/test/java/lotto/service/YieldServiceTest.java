package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoResultConstant;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class YieldServiceTest {

    private LottoResultService lottoResultService = new LottoResultService();
    private YieldService yieldService = new YieldService();

    @DisplayName("결과를 잘 뱉어내는지 확인한다")
    @Test
    void yieldTest1() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusLotto = 7;

        Map<LottoResultConstant, Integer> result = lottoResultService.getResult(lottos,
                new WinningLotto(new Lotto(winningLotto), bonusLotto));
        Money money = new Money("8000");
        DecimalFormat format = new DecimalFormat("###,###.#");
        String format1 = format.format(yieldService.calculateYield(result, money));
        assertThat(format1).isEqualTo("62.5");

    }

    @DisplayName("결과를 잘 뱉어내는지 확인한다")
    @Test
    void yieldTest2() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(2, 1, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusLotto = 7;

        Map<LottoResultConstant, Integer> result = lottoResultService.getResult(lottos,
                new WinningLotto(new Lotto(winningLotto), bonusLotto));
        Money money = new Money("8000");
        DecimalFormat format = new DecimalFormat("###,###.#");
        String format1 = format.format(yieldService.calculateYield(result, money));
        assertThat("25,000,062.5").isEqualTo(format1);
    }
}