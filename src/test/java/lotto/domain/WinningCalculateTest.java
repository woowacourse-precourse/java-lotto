package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningCalculateTest {
    private List<Integer> winningNumber = List.of(1,2,3,4,5,6);
    private List<Lotto> lottoNumber = List.of(
            new Lotto(List.of(1,2,3,4,5,6)),
            new Lotto(List.of(2,3,4,5,6,7)),
            new Lotto(List.of(2,3,4,5,6,8)),
            new Lotto(List.of(2,3,4,5,8,9)),
            new Lotto(List.of(2,3,4,8,9,10))
    );
    private int bonusNumber = 7;
    WinningCalculate winningNumberTest = new WinningCalculate(winningNumber,lottoNumber,bonusNumber);

    @DisplayName("주어진 등수와 비교하여 테스트")
    @Test
    void createRank() {
        List<Integer> rank = List.of(1,2,3,4,5);
        assertThat(winningNumberTest.getRANK()).isEqualTo(rank);
    }
}

