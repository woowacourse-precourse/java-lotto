package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyViewTest {
    @DisplayName("금액이 숫자가 아닐 경우 예외를 발생시킵니다.")
    @Test
    void 금액_입력값_예외처리_테스트1() {
        InputStream in = new ByteArrayInputStream("aaa".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> MoneyView.get())
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원단위가 아닐 경우 예외를 발생시킵니다.")
    @Test
    void 금액_입력값_예외처리_테스트2() {
        InputStream in = new ByteArrayInputStream("1200".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> MoneyView.get())
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
