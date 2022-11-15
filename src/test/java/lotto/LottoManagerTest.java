package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {

    @Test
    void hasBonusNumberTest() {
        LottoManager lottoManager = new LottoManager();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        boolean result = false;
        assertThat(lottoManager.hasBonusNumber(lotto, bonusNumber)).isEqualTo(result);
    }

    @Test
    void getMatchCountTest() {
        LottoManager lottoManager = new LottoManager();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumbers = List.of(4,5,6,7,8,9);
        int result = 3;
        assertThat(lottoManager.getMatchCount(lotto, winningNumbers)).isEqualTo(result);
    }
}