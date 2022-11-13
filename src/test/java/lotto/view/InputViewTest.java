package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lotto.util.ViewConst;

class InputViewTest {

	private InputView inputView = new InputView();
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));

		String text = " ";
		InputStream in = new ByteArrayInputStream(text.getBytes());
		System.setIn(in);
	}

	@Test
	void printStartTest() {
		inputView.printStart();
		assertThat(outContent.toString()).contains(ViewConst.START_INPUT);
	}

	@Test
	void printWinnerNumberTest() {
		inputView.printWinnerNumber();
		assertThat(outContent.toString()).contains(ViewConst.WIN_NUMBER_INPUT);
	}

	@Test
	void printBonusNumberTest() {
		inputView.printBonusNumber();
		assertThat(outContent.toString()).contains(ViewConst.BONUS_INPUT);
	}
}
