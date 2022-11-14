package view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import model.Lotto;

public class LottoOutputTest {

	private LottoOutput lottoOutput = new LottoOutput();

	@Nested
	class SuccessTest {
		private final ByteArrayOutputStream output = new ByteArrayOutputStream();

		@BeforeEach
		void outputSetting() {
			System.setOut(new PrintStream(output));
		}

		@Test
		@DisplayName("로또 출력 기능 테스트")
		void lottoOutput() {
			// given
			List<Integer> randomNumbers = List.of(1, 34, 32, 11, 10, 9);

			// when
			Lotto lotto = new Lotto(randomNumbers);
			String expectedLottoNumbers = "[1, 34, 32, 11, 10, 9]";

			// then
			lottoOutput.showLotto(lotto);
			assertThat(output.toString()).contains(expectedLottoNumbers);
		}

		@AfterEach
		void outputReset() {
			System.setOut(System.out);
			output.reset();
		}
	}
}
