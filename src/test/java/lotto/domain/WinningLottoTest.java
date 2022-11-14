package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningLottoTest {
    @DisplayName("번호 당첨 개수 테스트")
    @Test
    void correctCountTest() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        int correctCount = winningLotto.lottoContainsCount(List.of(2, 3, 4, 5, 6, 7));
        assertThat(correctCount).isEqualTo(5);
    }

    @DisplayName("로또 비교 테스트")
    @Test
    void lottoRankTest() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(45, 12, 44, 32, 5, 7))
        );

        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        winningLotto.compareLotto(lottos);
        
        assertThat(winningLotto.getLottoRank()).isEqualTo(List.of(1, 1, 0, 0, 0, 1));
    }
}