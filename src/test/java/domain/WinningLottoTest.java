package domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 개수에 따라서 등수를 카운팅한다.")
    public void 당첨_개수에_따른_카운팅() throws Exception {
        //given
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1,2,3,4,5,6)), // 1등
                new Lotto(List.of(1,2,3,4,5,9)), // 2등
                new Lotto(List.of(1,2,3,4,9,11)), // 3등
                new Lotto(List.of(1,2,3,4,24,33)), // 4등
                new Lotto(List.of(1,2,3,16,45,18)) // 5등
        );
        String input = "1,2,3,4,5,6" +
                "\n9";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        WinningLotto winningLotto = new WinningLotto();
        Map<Rank, Integer> checking = winningLotto.checking(tickets);

        //then
        for (Rank key : Rank.values()) {
            assertThat(checking.get(key)).isEqualTo(1);
        }
    }
}