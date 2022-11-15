package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
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

    @DisplayName("당첨 로또 숫자와 중복인 보너스 번호를 입력받으면 에러를 반환한다.")
    @Test
    void createWinningLottoWithDuplicatedBonusNumber() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNo = new LottoNumber(2);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto(winLotto, bonusNo);
        });
    }
}
