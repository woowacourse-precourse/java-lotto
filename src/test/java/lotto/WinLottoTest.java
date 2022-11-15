package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinLottoTest {
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6","5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(",로 숫자를 구분하지 않는 경우 예외가 발생한다.")
    @Test
    void seperateNumbersWithCommas() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new WinLotto("1,2,3,4;5.6","7"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
