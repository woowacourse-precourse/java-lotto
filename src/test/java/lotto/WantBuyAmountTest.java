package lotto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WantBuyAmountTest {

    @DisplayName("희망 구매 금액이 1000 단위의 숫자가 아니면 예외가 발생한다.")
    @Test
    public void wantBuyAmountInputFail() {
        //given
        User user = new User();
        String input = "5500";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                user::wantBuyAmountInput);

        //then
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 1000단위의 숫자만 입력 가능합니다.");
    }

    @DisplayName("희망 구매 금액에 알맞은 입력값을 입력하면 int 로 변환하여 반환한다.")
    @Test
    public void wantBuyAmountInputSUC() {
        //given
        User user = new User();
        String input = "55000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        int wantBuyAmountInput = user.wantBuyAmountInput();

        //then
        assertThat(wantBuyAmountInput).isEqualTo(55000);
    }

    @DisplayName("희망 구매 금액에 숫자 외의 값을 입력하면 예외가 발생한다.")
    @Test
    public void wantBuyAmountInputNotNumber() {
        //given
        User user = new User();
        String input = "99000i";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                user::wantBuyAmountInput);

        //then
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 숫자만 입력 가능합니다.");
    }
}
