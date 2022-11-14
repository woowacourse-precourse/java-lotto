package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckLottosPrizeTest {
    private Lotto winningNumbers;
    private Integer bonusNumber;
    private List<Lotto> lottos;
    private CheckLottosPrize checkLottosPrize;

    @BeforeEach
    void testInit() {
        winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 45;
        lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 45)));
        lottos.add(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)));
        lottos.add(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)));
        lottos.add(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)));
        checkLottosPrize = new CheckLottosPrize(lottos, winningNumbers, bonusNumber);
    }

    @Test
    @DisplayName("번호가 일치하는 수에 따라 당첨 등수가 정해지는지 확인한다.")
    void checkAllRankOfLottos() {
        Map<String, Integer> totalPrize = checkLottosPrize.getTotalPrize();
        assertThat(totalPrize).contains(
                entry("FIRST", 1),
                entry("SECOND", 1),
                entry("THIRD", 1),
                entry("FOURTH", 1),
                entry("FIFTH", 1));
    }
}