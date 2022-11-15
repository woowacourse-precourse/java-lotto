package lotto.model;

import lotto.resource.WinningType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

class LottoWinningAnalyzerTest {
    private static List<Lotto> lottoTickets = new ArrayList<>();

    @BeforeAll
    static void setLottoTickets() {
        List<List<Integer>> numbers = List.of(
                List.of(15, 16, 19, 20, 31, 45),
                List.of(35, 2, 13, 41, 42, 43),
                List.of(36, 35, 2, 7, 14, 13),
                List.of(6, 3, 1, 17, 22, 24));

        for (int i = 0; i < numbers.size(); i++) {
            lottoTickets.add(new Lotto(numbers.get(i)));
        }
    }

    @DisplayName("로또 구매 번호와 당첨 번호를 통해 당첨 결과를 확인한다")
    @Test
    void checkWinningResult() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(2, 13, 35, 14, 41, 42)), 43
        );
        LottoWinningAnalyzer analyzer = new LottoWinningAnalyzer(winningLotto);
        EnumMap<WinningType, Integer> result = analyzer.calculateWinningResult(lottoTickets);

        Assertions.assertThat(result.keySet().stream()
                        .filter(winningType -> result.get(winningType) > 0)
                        .collect(Collectors.toList()))
                .containsExactly(WinningType.FOUR, WinningType.FIVE_AND_BONUS);
    }
}