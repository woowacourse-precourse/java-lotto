package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinNumberTest {

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다..")
    @Test
    void createWinNumberByOverSize() {
        assertThatThrownBy(() -> new WinNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
