package lotto;

import lotto.model.Input_Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Input_NumbersTest {

    @DisplayName("입력된 금액이 공백이나 입력을 안했을 경우 예외 발생")
    @Test
    void 입력된_금액이_빈_공백이거나_입력을_안했을_경우_확인() {
        Input_Numbers input_money = new Input_Numbers();

        String input = " 32523";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            input_money.input_Money();
        });
        assertThat(exception.getMessage()).contains("정수가 아닌 문자 혹은 실수가 입력되었습니다.");

    }

    @DisplayName("입력된 금액이 음수일 경우 예외 발생")
    @Test
    void 입력된_금액이_음수일_경우_확인() {
        Input_Numbers input_money = new Input_Numbers();

        String input = "-1000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            input_money.input_Money();
        });
        assertThat(exception.getMessage()).contains("음수가 입력되었습니다.");
    }

    @DisplayName("입력된 금액이 로또 구매할때 나눠지지 않을 경우(해당 금액이 1000원으로 나눠지지 않을 경우) 예외 발생")
    @Test
    void 입력된_금액이_1000원으로_나눠지지_않을_경우() {
        Input_Numbers input_money = new Input_Numbers();

        String input = "1400";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            input_money.input_Money();
        });
        assertThat(exception.getMessage()).contains("입력된 금액이 1000원 단위로 떨어지지 않습니다.");
    }

    @DisplayName("당첨 번호를 입력할 때 음수인 숫자가 존재하는 경우 예외 발생")
    @Test
    void 번호들이_정해진_범위안에_존재하는_경우() {
        Input_Numbers input_money = new Input_Numbers();

        String input = "1,2,3,4,90,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            input_money.input_WinNumbers();
        });
        assertThat(exception.getMessage()).contains("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("입력된 금액 혹은 번호에 문자가 섞여있을 경우 예외 발생")
    @Test
    void 입력된_금액_혹은_번호에_문자가_섞여있을_경우_확인() {
        Input_Numbers input_money = new Input_Numbers();

        String input = "12345b";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            input_money.input_Money();
        });
        assertThat(exception.getMessage()).contains("정수가 아닌 문자 혹은 실수가 입력되었습니다.");
    }

    @DisplayName("당첨 번호의 개수를 제대로 입력하지 않을 경우 예외 발생")
    @Test
    void 당첨_번호의_개수를_제대로_입력하지_않았을_경우() {
        Input_Numbers input_money = new Input_Numbers();

        String input = "1,2,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            input_money.input_WinNumbers();
        });
        assertThat(exception.getMessage()).contains("정해진 로또번호의 개수가 입력되지 않았습니다.");
    }

    @DisplayName("당첨 번호를 입력할 때 숫자가 중복될 경우가 존재하는 경우 예외 발생")
    @Test
    void 당첨번호에서_중복된_숫자가_존재하는_경우() {
        Input_Numbers input_money = new Input_Numbers();

        String input = "1,2,3,4,5,5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            input_money.input_WinNumbers();
        });
        assertThat(exception.getMessage()).contains("중복이 발생하였습니다.");
    }

    @DisplayName("보너스 번호가 당첨번호와 겹찰 경우 예외 발생")
    @Test
    void 보너스번호가_당첨번호와_겹칠_경우() {
        Input_Numbers input_money = new Input_Numbers();

        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            input_money.input_BonusNumber(List.of(1, 2, 3, 4, 5, 6));
        });
        assertThat(exception.getMessage()).contains("입력된 보너스 번호가 당첨 번호와 중복되었습니다.");
    }
}
