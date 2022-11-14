package lotto;

import lotto.LottoManager.LottoDrawingMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoDrawTest {

    @DisplayName("로또 당첨 번호 입력 시 여섯개의 숫자가 ','로 구분되어 입력되어야한다")
    @Test
    void 로또추첨_예외처리_테스트1() {
        assertThatThrownBy(() -> LottoDrawingMachine.drawLottoForTest(List.of("1,2,3,4,5,6,", "7")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoDrawingMachine.drawLottoForTest(List.of("1,2,3,4,5/6", "7")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoDrawingMachine.drawLottoForTest(List.of("b,2,3,4,5,a", "7")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 보너스 번호 입력 시 한개의 숫자만 입력되어야한다")
    @Test
    void 로또추첨_예외처리_테스트2() {
        assertThatThrownBy(() -> LottoDrawingMachine.drawLottoForTest(List.of("1,2,3,4,5,6,", ",12")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoDrawingMachine.drawLottoForTest(List.of("1,2,3,4,5/6", "a")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력 시 1부터 45까지의 숫자로 입력해야한다")
    @Test
    void 로또추첨_예외처리_테스트3() {
        assertThatThrownBy(() -> LottoDrawingMachine.drawLottoForTest(List.of("1,2,3,4,5,46", "7")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoDrawingMachine.drawLottoForTest(List.of("0,2,3,4,5,45", "7")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoDrawingMachine.drawLottoForTest(List.of("1,2,3,4,5,45", "46")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

