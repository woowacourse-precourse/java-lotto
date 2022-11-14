package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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
	
	@DisplayName("당첨번호 입력 - 6개 미만 당첨번호 입력")
	@Test
	void inputWinningNumbersJust5() {
		SetSystemInput("1,2,3,4,5");
		assertThatThrownBy(() -> InputUtil.inputWinnigNumber())
		.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("당첨번호 입력 - 숫자가 아닌 당첨번호 입력")
	@Test
	void inputWinningNumbersNotNumber() {
		SetSystemInput("1,2,3,4,5,jd");
		assertThatThrownBy(() -> InputUtil.inputWinnigNumber())
		.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("당첨번호 입력 - 범위가 아닌 당첨번호 입력")
	@Test
	void inputWinningNumbersNotRange() {
		SetSystemInput("1,2,3,4,5,66");
		assertThatThrownBy(() -> InputUtil.inputWinnigNumber())
		.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("당첨번호 입력 - 올바른 당첨번호 입력")
	@Test
	void inputWinningNumbersIsRight() {
		SetSystemInput("1,2,3,4,5,6");
		List<Integer> expect = new ArrayList<>();
		expect.add(1);
		expect.add(2);
		expect.add(3);
		expect.add(4);
		expect.add(5);
		expect.add(6);
		assertThat(InputUtil.inputWinnigNumber()).isEqualTo(expect);
	}
	


	@DisplayName("보너스번호 입력 - 숫자가 아닌 당첨번호 입력")
	@Test
	void inputBonusNumbersNotNumber() {
		SetSystemInput("A");
		assertThatThrownBy(() -> InputUtil.inputBonusNumber())
		.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스번호 입력 - 범위가 아닌 당첨번호 입력")
	@Test
	void inputBonusNumbersNotRange() {
		SetSystemInput("70");
		assertThatThrownBy(() -> InputUtil.inputBonusNumber())
		.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("보너스번호 입력 - 올바른 당첨번호 입력")
	@Test
	void inputBonusNumbersIsRight() {
		SetSystemInput("1");
		assertThat(InputUtil.inputBonusNumber()).isEqualTo(1);
	}
	
	public void SetSystemInput(String input) {
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
}
