package lotto.Function;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {
    @DisplayName("유저의 로또 번호와 당첨 번호를 대조해본다.")
    @Test
    void winningNumCheck() {
        Checker checker = new Checker(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6));
        assertEquals(6, checker.winningNumCheck());
    }

}