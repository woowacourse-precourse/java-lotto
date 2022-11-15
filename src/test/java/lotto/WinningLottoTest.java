package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    void 보너스번호_중복() {
        assertThatThrownBy(() -> {
            Lotto l = new Lotto(List.of(1,2,3,4,5,6));
            new WinningLotto(l,5);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + " 보너스 번호는 중복될 수 없습니다.");
    }
    @Test
    void 보너스번호_범위() {
        assertThatThrownBy(() -> {
            Lotto l = new Lotto(List.of(1,2,3,4,5,6));
            new WinningLotto(l,0);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + " 보너스 번호는 1에서 45까지의 수입니다.");
    }
}
