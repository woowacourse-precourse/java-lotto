package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.InputUtil;

public class InputUtilTest {

	
	@DisplayName("구입금액을 숫자가 아닌 글자로 입력 시 오류 발생.")
    @Test
    void inputPriceisNumberTest() {
		SetSystemInput("abc");
        assertThatThrownBy(() -> InputUtil.inputPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("구입금액이 1000의 배수가 아닐시 오류 발생.")
	@Test
	void inputPriceisMultipleOf1000() {
		SetSystemInput("1200");
		assertThatThrownBy(() -> InputUtil.inputPurchaseAmount())
		.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("구입금액 3000 정상 입력 확인")
	@Test
	void inputPriceisRight() {
		SetSystemInput("3000");
		assertThat(InputUtil.inputPurchaseAmount()).isEqualTo(3000);
	}

	
	public void SetSystemInput(String input) {
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
}
