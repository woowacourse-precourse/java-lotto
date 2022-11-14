package lotto.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    @Test
    void 숫자가_아닌_금액을_입력하면_예외가_발생한다(){
        // given
        String money = "1234j";

        // when
        InputStream in = new ByteArrayInputStream(money.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThatThrownBy(() -> InputView.getUserMoney())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다.");
    }

    @Test
    void 숫자가_아닌_보너스_번호를_입력하면_예외가_발생한다(){
        // given
        String money = "a";

        // when
        InputStream in = new ByteArrayInputStream(money.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThatThrownBy(() -> InputView.getBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다.");
    }


    @Test
    void 최대_금액보다_큰_금액을_입력하면_예외가_발생한다(){
        // given
        String money = String.valueOf(Long.MAX_VALUE);

        // when
        InputStream in = new ByteArrayInputStream(money.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThatThrownBy(() -> InputView.getUserMoney())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력할 수 있는 금액의 최대값을 넘었습니다.");
    }
}