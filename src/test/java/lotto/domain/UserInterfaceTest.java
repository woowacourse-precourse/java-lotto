package lotto.domain;

import lotto.domain.model.Message;
import lotto.domain.ui.Printer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {
	final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	final PrintStream standardOut = System.out;


	@BeforeEach
	void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	void tearDown() {
		System.setOut(standardOut);
	}


	@Test
	void 출력_테스트(){
		String str = "구입금액을 입력해 주세요.";
		Printer ui = new Printer();
		ui.printMessage(Message.START);
		assertEquals(str, outputStreamCaptor.toString().trim());

	}

}