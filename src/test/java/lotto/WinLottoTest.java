package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WinLottoTest {

    @Test
    void validateWinLottoNumbersRange() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void createWinLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createWinLottoByWrongNumber() {
        assertThatThrownBy(() -> {
            WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 6));

            winLotto.validateBonusNumberUniqueness(1);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void matchTest() {
        WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 6));
        winLotto.setBonus(7);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        assertThat(winLotto.matches(lotto)).isEqualTo(Result.FiveBonus.message);
    }

}