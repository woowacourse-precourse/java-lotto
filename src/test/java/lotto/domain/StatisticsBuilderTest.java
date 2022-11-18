package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsBuilderTest {
    @Test
    @DisplayName("구매한 로또에 대한 당첨여부를 정확히 수집하고 출력하는 지 테스트")
    void statistics_builder_build_test() {
        StatisticsBuilder builder = new StatisticsBuilder();
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4 ,5, 6));
        int bonusNumber = 10;

        List<Integer> winningOne = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningTwo = new ArrayList<>(List.of(1, 2, 3, 4, 5, 10));
        List<Integer> winningThree = new ArrayList<>(List.of(1, 2, 3, 4, 5, 13));
        List<Integer> winningFour = new ArrayList<>(List.of(1, 2, 3, 4, 7, 13));
        List<Integer> winningFive = new ArrayList<>(List.of(1, 2, 3, 7, 9, 13));
        List<Integer> winningNone = new ArrayList<>(List.of(1, 2, 7, 8, 9, 10));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(winningOne));
        lottos.add(new Lotto(winningTwo));
        lottos.add(new Lotto(winningThree));
        lottos.add(new Lotto(winningFour));
        lottos.add(new Lotto(winningFive));
        lottos.add(new Lotto(winningNone));

        builder.build(winningNumber, bonusNumber, lottos);

        Map<String, Integer> result = builder.getWinningInfo();
        Map<String, Integer> solution = new HashMap<>();
        solution.put("WINNING_ONE", 1);
        solution.put("WINNING_TWO", 1);
        solution.put("WINNING_THREE", 1);
        solution.put("WINNING_FOUR", 1);
        solution.put("WINNING_FIVE", 1);

        for(Map.Entry<String, Integer> entry : result.entrySet()) {
            assertEquals(result.get(entry.getKey()), solution.get(entry.getKey()));
        }
    }
}
