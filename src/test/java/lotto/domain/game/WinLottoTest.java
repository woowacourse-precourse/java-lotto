package lotto.domain.game;

import lotto.domain.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinLottoTest {
    private WinLotto winningLotto;
    private Player player;

    @BeforeEach
    void setting(){
        player = new Player(5000);
        List<Integer> array = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto = new Lotto(array);
        lotto.setBonusNumber(7);
        winningLotto = new WinLotto(lotto, player);
    }

    @DisplayName("Map 초기화 테스트")
    @Test
    void initWinningResultTest(){
        Map<Ranking, Integer> exceptWinningResult = Arrays.stream(Ranking.values()).collect(toMap(ranking -> ranking, ranking -> 0));
        assertThat(winningLotto.getWinningResult()).isEqualTo(exceptWinningResult);
    }

    @DisplayName("발행된 로또 번호와 당첨 번호 비교가 잘되는지 테스트")
    @Test
    void compareLottoAndWinningNumber(){
        List<Integer> lottoTicket = List.of(1,2,3,10,35,26);
        int count = 3;

        assertThat(winningLotto.countMatchWinningNumber(lottoTicket)).isEqualTo(count);
    }

    @DisplayName("발행된 로또 번호에 보너스 번호가 있는지 비교하는게 잘되는지 테스트")
    @Test
    void compareLottoAndBonus(){
        List<Integer> lottoTicket = List.of(1,2,7,10,35,26);

        assertThat(winningLotto.isBonusNumberMatch(lottoTicket)).isEqualTo(true);
    }
}
