package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class JudgeTest {

    @DisplayName("여러개의 복권의 등수를 판단하여 리스트에 개수를 넣는다.")
    @Test
    void createLottoRankList() {
        List<Lotto> lotteries = new ArrayList<>();
        List<Integer> example = List.of(1, 2, 3, 4, 5, 6);
        for (int i = 0; i < 6; i++)
            lotteries.add(new Lotto(example));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        Judge judge = new Judge();
        judge.setRankCount(lotteries, winningNumbers);
        List<Integer> result = List.of(0, 6, 0, 0, 0, 0);
        assertThat(judge.rankCount).isEqualTo(result);
    }
}