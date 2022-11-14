package lotto.view;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberViewTest {
    @DisplayName("당첨번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 당첨번호_입력_예외_테스트1() {
        InputStream in = new ByteArrayInputStream("1,2,3,4,a,6,7".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> NumberView.getWinNumbers())
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨번호 형식과 다를 경우 예외가 발생한다.")
    @Test
    void 당첨번호_입력_예외_테스트2() {
        InputStream in = new ByteArrayInputStream("1 2 3 4 5 6 7".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> NumberView.getWinNumbers())
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
