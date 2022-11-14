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
}