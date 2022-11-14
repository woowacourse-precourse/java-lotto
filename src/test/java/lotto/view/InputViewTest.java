package lotto.view;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

// 개별 테스트 필요
public class InputViewTest {
    @DisplayName("숫자 앞 뒤에 공백이 있는 money 입력은 정상 처리한다.")
    @Test
    void moneyInputWithLeadingAndTrailingSpace() {
        String input = " 1234 \n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(InputView.takeMoneyInput()).isEqualTo(1234);
    }

    @DisplayName("money 입력으로 빈 값이 입력된 경우 IllegalArgumentException 에러를 발생시킨다.")
    @Test
    void moneyInputWithEmptyValue() {
        String input = "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(InputView::takeMoneyInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("값을 입력하지 않았습니다.");
    }

    @DisplayName("money 입력으로 숫자가 아닌 값이 입력된 경우 IllegalArgumentException 에러를 발생시킨다.")
    @Test
    void moneyInputWithNonNumericValue() {
        String input = "123a4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(InputView::takeMoneyInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해주세요.");
    }
}
