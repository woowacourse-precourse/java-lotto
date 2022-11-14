package lotto.Domain.Exception;

import lotto.Input.LottoValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class CheckExceptionTest {
    CheckException checkException = new CheckException();
    @DisplayName("int로 잘 변환하는가, 문자가 있으면 예외 발생하는가")
    @Test
    void createIntValue() {
        String strNoraml = "1";
        String strError = "as11";

        assertThat(checkException.check_HaveChar_And_Convert(strNoraml))
        .isEqualTo(1);

        assertThatThrownBy(() -> checkException.check_HaveChar_And_Convert(strError))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1에서 45 밖의 숫자를 입력하면 예외 발생하는가")
    @Test
    void createOutOfRange() {
        int outOfMax = 46;
        int outOfMin = 0;

        assertThatThrownBy(() -> checkException.check_OutOfRange(outOfMax))
        .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> checkException.check_OutOfRange(outOfMin))
        .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("1000으로 나누어 떨어지지 않으면 예외 발생하는가")
    @Test
    void createDivideError() {
        int thousandError = 1001;

        assertThatThrownBy(() -> checkException.check_OutOfRange(thousandError))
        .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 발행 수량이 맞지 않으면 예외 발생하는가")
    @Test
    void createSizeError() {
        int sizeError = LottoValue.SIZE.getNum()+1;
        assertThatThrownBy(() -> checkException.check_LottoSize(sizeError))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 안에 중복 숫자 있으면 예외 발생하는가")
    @Test
    void createOverlapError() {
        int size = LottoValue.SIZE.getNum();
        List<Integer> compareNumsError = List.of(1,2,3,4,5,5);

        assertThatThrownBy(() -> checkException.check_RelativeLottoSize(size, compareNumsError))
        .isInstanceOf(IllegalArgumentException.class);
    }
}
