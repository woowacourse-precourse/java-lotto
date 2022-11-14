package lotto;

import lotto.view.validation.MoneyValidation;
import lotto.view.validation.LottoValidation;
import lotto.view.validation.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    Validation validation1 = new MoneyValidation();
    Validation validation2 = new LottoValidation();

    @DisplayName("입력값 문자 예외 테스트")
    @Test
    void validationNumber1() {
        assertThatThrownBy(() -> validation1.validateInputIsInteger("1000fghj"))
                .isInstanceOf(NoSuchElementException.class);

    }

    @DisplayName("입력값 숫자 확인 검사")
    @Test
    void validationNumber2() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        validation1.validateInputIsInteger("1000");

        assertThat(out.toString()).contains("");
    }

    @DisplayName("배열에 숫자외의 문자가 들었는지 확인")
    @Test
    void validationNumber3() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        validation2.validateInputIsInteger("1,2,3,4,5,6");

        assertThat(out.toString()).contains("");
    }

    @DisplayName("int인지 아닌지 확인4")
    @Test
    void validationNumber4() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        validation1.validateInputIsInteger("1000");

        assertThat(out.toString()).contains("1000");
    }
}
