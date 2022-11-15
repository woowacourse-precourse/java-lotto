package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import static lotto.ErrorCode.*;

public class LogicTest {
    Logic logic = new Logic();

    @DisplayName("[ERROR] 로또 구입 금액은 1000원 단위로 입력되어야 합니다.")
    @Test
    void 로또_수량_에러_테스트() {
        assertThatThrownBy(() -> logic.checkPieces("10000j"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> logic.checkPieces("100"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> logic.checkPieces("j000"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> logic.checkPieces("15500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_수량_정상_테스트() {
        assertThat(logic.checkPieces("12000")).isEqualTo(12);
    }

    @Test
    void 로또_당첨_에러_테스트() {
        assertThatThrownBy(() -> logic.setJackpot("1, ,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> logic.setJackpot("1j2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> logic.setJackpot("-1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> logic.setJackpot("1,2,3,4,5,66"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> logic.setJackpot("1,2,3,4,5,,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> logic.setJackpot("1,2,3,4,07,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨_정상_테스트() {
        assertThat(logic.setJackpot("1,2,3,4,5,6")).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 보너스_당첨_에러_테스트() {
        assertThatThrownBy(() -> logic.setBonus("7", List.of(1, 2, 3, 4, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> logic.setBonus("-1", List.of(1, 2, 3, 4, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> logic.setBonus("?", List.of(1, 2, 3, 4, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> logic.setBonus("66", List.of(1, 2, 3, 4, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_당첨_정상_테스트() {
        assertThat(logic.setBonus("7", List.of(1, 2, 3, 4, 5, 6))).isEqualTo(7);
    }
}
