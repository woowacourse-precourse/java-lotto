package lotto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ControllerTest {

	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		LottoGameController lottoGameController =  new LottoGameController();
		SetSystemInput("99900000");
		lottoGameController.inputPurchaseAmount();
		lottoGameController.issueLotto();
		lottoGameController.printIssueLotto();
		SetSystemInput("1,11,10,21,31,19");
		lottoGameController.inputWinningNumber();
		SetSystemInput("8");
		lottoGameController.inputBonusNumber();
		lottoGameController.calculateResult();
		lottoGameController.printResult();
	}
	
	public void SetSystemInput(String input) {
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
}
