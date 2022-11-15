package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoDrawingTest {

    @Test
    void 당첨번호_비정상입력_숫자x() {
        assertThatThrownBy(() -> new LottoDrawing("1,2,3,4,5,o", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]");
    }

}