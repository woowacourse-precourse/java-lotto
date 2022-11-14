package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrawTest {

    @Test
    @DisplayName("자동번호와 당첨번호 일치하는 갯수 확인")
    void numberCount() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(Draw.numberCount(winningNumbers, lotto), 6);
    }

    @Test
    @DisplayName("2등 3등 비교하기 위한 보너스넘버 확인")
    void isMatchBonusNumber() {
        int bonusNumber = 20;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 20));

        assertEquals(Draw.isMatchBonusNumber(bonusNumber, lotto), true);

    }
}