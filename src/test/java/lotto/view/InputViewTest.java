package lotto.view;

import lotto.mock.MockInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("InputView 테스트")
class InputViewTest {
	private InputView inputView;

	@Nested
	@DisplayName("사용자로부터 로또를 구입할 금액을 입력받는 getMoney 테스트")
	class GetMoneyTest {
		@Test
		@DisplayName("구입금액 입력을 유도하는 메시지가 출력된다.")
		void givenNothing_whenRunningInputView_thenPrintsInputMoneyMessage () {
			//given
			inputView = new MockInputView("14000");

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
			//given
			inputView = new MockInputView("14000");

			//when & then
			assertThat(inputView.getMoney()).isEqualTo("14000");
		}
	}

	@Nested
	@DisplayName("사용자로부터 로또 당첨 금액을 입력받는 getWinningNumbers 테스트")
	class GetWinningNumbersTest {
		@Test
		@DisplayName("당첨 번호 입력을 유도하는 메시지가 출력된다.")
		void givenNothing_whenRunningInputView_thenPrintsInputWinningMessage() {
			//given
			inputView = new MockInputView("3, 6, 12, 18, 31, 37");

			OutputStream out = new ByteArrayOutputStream();
			System.setOut(new PrintStream(out));

			//when
			inputView.getWinningNumbers();

			//then
			assertThat(out.toString()).isEqualTo(InputViewImpl.INPUT_WINNING_NUMBERS_MESSAGE + "\n\n");
		}

		@Test
		@DisplayName("사용자로부터 당첨 번호를 입력받을 수 있다.")
		void givenNothing_whenRunningInputView_thenReturnsWinning() {
			//given
			inputView = new MockInputView("3, 6, 12, 18, 31, 37");

			//when & then
			assertThat(inputView.getWinningNumbers()).isEqualTo("3, 6, 12, 18, 31, 37");
		}
	}

	@Nested
	@DisplayName("사용자로부터 로또 당첨 금액을 입력받는 getBonus 테스트")
	class GetBonusTest {
		@Test
		@DisplayName("보너스 번호 입력을 유도하는 메시지가 출력된다.")
		void givenNothing_whenRunningInputView_thenPrintsInputBonusMessage() {
			//given
			inputView = new MockInputView("9");
			OutputStream out = new ByteArrayOutputStream();
			System.setOut(new PrintStream(out));

			//when
			inputView.getBonus();

			//then
			assertThat(out.toString()).isEqualTo(InputViewImpl.INPUT_BONUS_MESSAGE + "\n\n");
		}

		@Test
		@DisplayName("사용자로부터 보너스 번호를 입력받을 수 있다.")
		void givenNothing_whenRunningInputView_thenReturnsBonus() {
			//given
			inputView = new MockInputView("9");

			//when & then
			assertThat(inputView.getBonus()).isEqualTo("9");
		}
	}
}