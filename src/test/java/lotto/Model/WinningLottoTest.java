package lotto.Model;

import static lotto.Model.WinningRank.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    Buyer buyer = new Buyer("1000");
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

    @DisplayName("맞춘 로또 번호의 개수를 구한다.")
    @Test
    void ConutMatchedLottoNumber() {
        int result = winningLotto.matchNumberCount(lotto);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("보너스 번호를 맞췄는지 여부를 구한다.")
    @Test
    void FalseToMatchBonus() {
        boolean result = winningLotto.isMatchBonusNumber(lotto);
        assertThat(result).isEqualTo(false);
    }

    @DisplayName("몇등에 당첨됐는지를 구한다.")
    @Test
    void makeRankResult() {
        List<WinningRank> rank = winningLotto.makeRankResult(buyer);
        List<WinningRank> rankList = List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH);
        boolean result = rankList.contains(rank.get(0));
        assertThat(result).isEqualTo(true);
    }


}
