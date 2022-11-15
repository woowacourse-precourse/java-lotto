package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.player.Host;
import lotto.ticket.Lotto;
import lotto.ticket.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HostTest {

    @Test
    @DisplayName("로또_추첨_테스트")
    public void drawLotto() throws Exception {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int winningBonusNumber = 7;
        Host host = new Host(winningLotto, winningBonusNumber);

        //when
        List<Lotto> userLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        List<Winning> drawResult = host.drawLotto(userLottos);

        //then
        assertThat(drawResult).isEqualTo(List.of(Winning.SIX, Winning.BONUS));
    }

}