package lotto;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class InputViewTest {

	@Test
	void 로또_구입_금액_출력() {
		//given
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		String input = "14000";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		//when
		InputView.inputMoney();

		//then
		assertThat(out.toString()).isEqualTo("구입금액을 입력해 주세요." + System.lineSeparator());
	}

	@Test
	void 로또_구입_금액_결과() {
		//given
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		String input = "14000";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		//when
		int money = InputView.inputMoney();

		//the
		assertThat(money).isEqualTo(14000);
	}

	@Test
	void 로또_구입_금액_숫자_아닌_경우() {
		//given
		String input = "---!!";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		//then
		assertThatThrownBy(InputView::inputMoney).isInstanceOf(Exception.class);
	}

	@Test
	void 당첨_번호_입력() {
		//given
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		String input = "1, 2, 3, 4, 5, 6";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		//when
		InputView.inputWinLottoNumbers();

		//then
		assertThat(out.toString()).isEqualTo("지난 주 당첨 번호를 입력해 주세요." + System.lineSeparator());
	}
}