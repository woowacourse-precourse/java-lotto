package lotto.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.ui.OutputMessageGenerator.*;

public class OutputMessageGeneratorTest {
    @DisplayName("`[구매 수량]개를 구매했습니다.` 를 반환한다.")
    @Test
    void getPurchaseLottoMessageTest() {
        assertThat(getPurchaseLottoMessage(4))
                .isEqualTo("4개를 구매했습니다.");
    }
}
