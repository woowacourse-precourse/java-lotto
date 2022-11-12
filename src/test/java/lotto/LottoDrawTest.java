package lotto;

import lotto.LottoManager.LottoDrawingMachine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoDrawTest {

    @Test
    void 로또추첨_예외처리_테스트() {
        assertThatThrownBy(()-> LottoDrawingMachine.validateDrawnNumbers("1,2,3,4,5,6","7"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> LottoDrawingMachine.validateDrawnNumbers("0,2,3,4,5,6","7"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> LottoDrawingMachine.validateDrawnNumbers("1,2,3,4,5,46","59"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> LottoDrawingMachine.validateDrawnNumbers("1,2,3,4,5,6","6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> LottoDrawingMachine.validateDrawnNumbers("1,2,4,4,5,6","7"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
