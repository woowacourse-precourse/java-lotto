package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("생성한 로또와 당첨 번호 비교하여 얻은 결과 확인")
    void checkResult() {
        Lotto l1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto l2 = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        Lotto l3 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto l4 = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Lotto l5 = new Lotto(List.of(1, 2, 3, 4, 7, 45));
        Lotto l6 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto l7 = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        Lotto l8 = new Lotto(List.of(1, 7, 8, 9, 10, 11));
        Lotto l9 = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        LottoTickets lottoTickets = new LottoTickets(List.of(
                l1, l2, l3, l4, l5, l6, l7, l8, l9
        ));

        WinningTicket winningTicket = new WinningTicket(List.of(1, 2, 3, 4, 5, 6), 45);
        List<Ranking> rankings = List.of(Ranking.FIRST, Ranking.SECOND, Ranking.THIRD, Ranking.FOURTH,
                Ranking.FOURTH, Ranking.FIFTH, Ranking.NOTHING, Ranking.NOTHING, Ranking.NOTHING);
        assertThat(lottoTickets.getResult(winningTicket)).isEqualTo(rankings);
    }
}
