package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();
    Player player = new Player();
    @DisplayName("당첨번호와 로또와 개수 맞는지 비교")
    @Test
    void findMathrankTest() {

        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        player.setWinningNumber(winning);
        player.setBonusNumber(bonus);

        // 로또 번호
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));         //6개 일치

        int ranking = lottoService.findMatchrank(lotto, player);
        assertThat(ranking).isEqualTo(1);
    }
}
