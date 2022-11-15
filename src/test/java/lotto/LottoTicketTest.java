package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    @Test
    void testCompareLotto() {
        LottoTicket lottoTicket = new LottoTicket();
        List<Lotto> lottos = new ArrayList<>();
        addLottos(lottos);
        lottoTicket.setBonus(7);
        lottoTicket.setWinnigLotto(List.of(1, 2, 3, 4, 5, 6));
        Map<LottoRanking, Integer> winningList = lottoTicket.compareLotto(lottos);
        OutputStream captor = new ByteArrayOutputStream();
        PrintStream standardOut;
        standardOut = System.out;
        System.setOut(new PrintStream(captor));
        printWinList(winningList);
        System.setOut(standardOut);
        assertThat(captor.toString().trim()).contains("FIRST 1", "SECOND 1", "THIRD 1", "FOURTH 1",
                "FIFTH 1", "NONE 1");

    }

    private void printWinList(Map<LottoRanking, Integer> winningList) {
        for (int i = 0; i < winningList.size(); i++) {
            System.out.println(
                    LottoRanking.values()[i].name() + " " + winningList.get(LottoRanking.values()[i]));
        }
    }

    private void addLottos(List<Lotto> lottos) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottos.add(lotto);
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lottos.add(lotto);
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        lottos.add(lotto);
        lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        lottos.add(lotto);
        lotto = new Lotto(List.of(1, 2, 3, 10, 8, 9));
        lottos.add(lotto);
        lotto = new Lotto(List.of(1, 2, 11, 10, 8, 9));
        lottos.add(lotto);
    }

    @Test
    void testCreateManyLotto() {
        LottoTicket lottoTicket = new LottoTicket();
        List<Lotto> lottos = lottoTicket.createManyLotto(9);
        assertEquals(9, lottos.size());
    }
}
