package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DrawTest {
    private static Draw draw;

    @BeforeEach
    private void initDraw() {
        draw = new Draw();
    }

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우")
    @Test
    void 올바른_구입금액_1000원_단위() {
        assertThrows(IllegalArgumentException.class,
                    () -> draw.startForTest("5800"));
    }

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우")
    @Test
    void 올바른_구입금액_숫자_포맷() {
        assertThrows(IllegalArgumentException.class,
                    () -> draw.startForTest("8000H"));
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아닌 경우")
    @Test
    void 올바른_보너스번호_1_45사이의_숫자() {
        assertThrows(IllegalArgumentException.class,
                    () -> draw.pickBonusNumberForTest("69"));
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우")
    @Test
    void 올바른_보너스번호_숫자_포맷() {
        assertThrows(IllegalArgumentException.class,
                    () -> draw.pickBonusNumberForTest("6j"));
    }
}
