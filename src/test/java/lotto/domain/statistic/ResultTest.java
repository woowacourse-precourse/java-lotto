package lotto.domain.statistic;

import lotto.domain.lotto.Lotto;
import lotto.domain.player.Lottos;
import lotto.domain.player.Player;
import lotto.domain.winner.LottoWinner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

class ResultTest {

    private Result result;
    private Lotto lotto;
    private LottoWinner winner;
    private Player player;
    private Lottos lottos;

    @BeforeEach
    void init() {
        lotto = Mockito.mock(Lotto.class);
        lottos = Mockito.mock(Lottos.class);
        player = Mockito.mock(Player.class);
        winner = Mockito.mock(LottoWinner.class);
        result = new Result(winner, lottos, player);
        when(winner.getBonusNumber()).thenReturn(7);
        when(winner.getLotto()).thenReturn(lotto);
        when(winner.getLotto().getNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 1등")
    @Test
    void 로또_일등_테스트() {
        Rank rank = result.getRank(lotto);
        assertThat(rank).isEqualTo(Rank.SIX);
    }
}