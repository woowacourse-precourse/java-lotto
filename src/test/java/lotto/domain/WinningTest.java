package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningTest {
    private LottoTicket lottoTicket;
    private WinningNumber winningNumber;
    private Winning winning;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 26));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 30));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 35, 8));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 42, 15, 40));
        Lotto lotto5 = new Lotto(List.of(1, 20, 31, 41, 42, 43));
        Lotto lotto6 = new Lotto(List.of(11, 20, 30, 40, 43, 44));

        lottoTicket = new LottoTicket("6000");
        winningNumber = new WinningNumber("1,2,3,4,5,6", "7");

        lottoTicket.getTicket().clear();
        lottoTicket.getTicket().add(lotto1);
        lottoTicket.getTicket().add(lotto2);
        lottoTicket.getTicket().add(lotto3);
        lottoTicket.getTicket().add(lotto4);
        lottoTicket.getTicket().add(lotto5);
        lottoTicket.getTicket().add(lotto6);

        winning = new Winning(lottoTicket, winningNumber);
        winning.checkWinningResult();
    }

    @DisplayName("각 등수에 맞게 결과가 생성되었는지 테스트.")
    @Test
    void resultMatchRank() {
        Map<LottoRank, Integer> result = winning.getLottoResult();

        assertThat(result.get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(result.get(LottoRank.FORTH)).isEqualTo(1);
        assertThat(result.get(LottoRank.THIRD)).isEqualTo(2);
        assertThat(result.get(LottoRank.SECOND)).isEqualTo(0);
        assertThat(result.get(LottoRank.FIRST)).isEqualTo(0);
        assertThat(result.get(LottoRank.MISS)).isEqualTo(2);
    }

    @DisplayName("수익률 소수점 둘째자리에서 반올림한 값 테스트.")
    @Test
    void totalRate() {
        assertThat(winning.getTotalRate()).isEqualTo(50916.7);
    }
}