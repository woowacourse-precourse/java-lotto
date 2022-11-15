package lotto.model.resources;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TotalWinningLottoTest {

    @Test
    void 클래스에_넣어주고_잘_들어갔는지_확인() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        LottoWin lottoWin = LottoWin.of(list);
        BonusLotto bonusLotto = BonusLotto.of("7", list);
        TotalWinningLotto totalWinningLotto = TotalWinningLotto.of(lottoWin, bonusLotto);
        Assertions.assertThat(totalWinningLotto.getWinningLotto()).isEqualTo(list);
        Assertions.assertThat(totalWinningLotto.getBonusLotto()).isEqualTo(7);
    }
}