package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
	private static InputView inputView;

	@BeforeAll
	static void setup() {
		inputView = new MockInputView();
	}

	@Test
	@DisplayName("구입금액 입력을 유도하는 메시지가 출력된다.")
	void givenNothing_whenRunningInputView_thenPrintsInputMoneyMessage () {
	    //given
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		//when
		inputView.getMoney();

		//then
		assertThat(out.toString()).isEqualTo(InputViewImpl.INPUT_MONEY_MESSAGE + "\n\n");
	}

	@Test
	@DisplayName("사용자로부터 구입 금액을 입력받을 수 있다.")
	void givenNothing_whenRunningInputView_thenReturnsUserMoney() {
	    //when & then
		assertThat(inputView.getMoney()).isEqualTo(MockInputView.MOCK_VALUE);
	}

	@Test
	@DisplayName("당첨 번호 입력을 유도하는 메시지가 출력된다.")
	void givenNothing_whenRunningInputView_thenPrintsInputWinningMessage() {
		//given
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

	    //when
		inputView.getWinning();

	    //then
		assertThat(out.toString()).isEqualTo(InputViewImpl.INPUT_WINNING_MESSAGE + "\n");
	}

	@Test
	@DisplayName("당첨 번호 입력을 유도하는 메시지가 출력된다.")
	void givenNothing_whenRunningInputView_thenReturnsWinning() {
	    //when & then
		assertThat(inputView.getWinning()).isEqualTo(MockInputView.MOCK_VALUE);
	}
}