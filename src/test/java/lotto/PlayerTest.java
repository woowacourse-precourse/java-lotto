package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    
    private Player player;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        player = new Player();
        
        lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        lottos.add(new Lotto(List.of(13, 14, 15, 16, 17, 18)));

        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 7), 8);
    }

    @Test
    void 당첨_번호와_사용자_구입_로또_번호의_일치_개수가_5개일_경우_3등_1개를_반환한다() {
        player.calculateRankStatistics(lottos, winningLotto);

        assertThat(player.getStatistics().get(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    void 사용자_구입_로또_개수가_3개이고_당첨_번호와의_일치_개수가_5개일_때의_수익률을_반환한다() {
        player.calculateRankStatistics(lottos, winningLotto);

        assertThat(player.calculateEarningRatio(3)).isEqualTo("50000.0");
    }
}