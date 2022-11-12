package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoControllerTest {
    @DisplayName("입력된 금액이 천원으로 나누어지는 수가 아닐시 예외 발생")
    @Test
    void createLottoByDuplicatedNumber() {
        //given
        LottoController lc = new LottoController();

        //then
        assertThatThrownBy(() -> lc.readUserMoney("1760"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
