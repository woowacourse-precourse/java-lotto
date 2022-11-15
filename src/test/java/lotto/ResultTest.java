package lotto;

import lotto.domain.Rank;
import lotto.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @DisplayName("당첨된 각 등수와 보너스 숫자 포함 결과를 포함하여 리턴하는지 확인")
    @Test
    void checkWinningResult() {
        List<Integer> matchResult = List.of(1, 5, 5, 3, 4, 6);
        List<Boolean> hasBonus = List.of(true, true, false, true, true, true);
        LinkedHashMap<Rank, Integer> result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 1);
        }
        assertThat(Result.getWinningResult(matchResult, hasBonus)).isEqualTo(result);
    }
}
