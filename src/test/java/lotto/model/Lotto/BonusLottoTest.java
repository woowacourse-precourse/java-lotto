package lotto.model.Lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BonusLottoTest {

    @DisplayName("보너스 로또 번호가 당첨인지 확인한다.")
    @Test
    void createLottoByOverSize() {
        BonusLotto bonusLotto = new BonusLotto(7);
        List<Integer> ticketDisMatchBonusLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> ticketMatchBonusLotto = List.of(7, 2, 3, 4, 5, 6);

        Assertions.assertEquals(bonusLotto.isBonusLotto(ticketDisMatchBonusLotto), false);
        Assertions.assertEquals(bonusLotto.isBonusLotto(ticketMatchBonusLotto), true);
    }
}