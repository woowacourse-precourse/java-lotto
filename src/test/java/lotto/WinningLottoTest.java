package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("5개의 숫자가 맞고 보너스 숫자가 맞으면 2등을 반환한다.")
    @Test
    void getSecondRankByComparingWinningLotto() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNo = new LottoNumber(8);
        WinningLotto winningLotto = new WinningLotto(winLotto, bonusNo);
        assertThat(winningLotto.match(userLotto)).isEqualTo(Rank.SECOND);
    }

}
