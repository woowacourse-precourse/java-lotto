package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


class WinningLottoTest {
    private final WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6,7");

    @Test
    void createWiningLotto1() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createWiningLotto2() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6,7,8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createWiningLotto3() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void evaluateTo1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(Optional.of(Prize.FIRST), winningLotto.evaluateTo(lotto));
    }

    @Test
    void evaluateTo2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        assertEquals(Optional.of(Prize.SECOND), winningLotto.evaluateTo(lotto));
    }

    @Test
    void evaluateTo3() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        assertEquals(Optional.of(Prize.THIRD), winningLotto.evaluateTo(lotto));
    }

    @Test
    void evaluateTo4() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));

        assertEquals(Optional.of(Prize.FOURTH), winningLotto.evaluateTo(lotto));
    }

    @Test
    void evaluateTo5() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertEquals(Optional.of(Prize.FIFTH), winningLotto.evaluateTo(lotto));
    }

    @Test
    void evaluateTo6() {
        Lotto lotto = new Lotto(List.of(1, 7, 8, 9, 10, 11));

        assertEquals(Optional.empty(), winningLotto.evaluateTo(lotto));
    }
}