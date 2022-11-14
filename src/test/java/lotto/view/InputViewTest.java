package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
	InputView inputView = new InputView();

	@Test
	@DisplayName("당첨 번호 입력의 형식이 올바른지 검증한다.")
	void v1alidateIntegerInput() {
		final byte[] buf = "12,12,,121,111,1,124".getBytes();
		System.setIn(new ByteArrayInputStream(buf));
		assertThatThrownBy(() -> inputView.getWinningNumbers()).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("당첨 번호를 검증하고 반환한다.")
	@Test
	void getWinningNumbers() {
		final byte[] buf = "2,12,18,35,56,62".getBytes();
		System.setIn(new ByteArrayInputStream(buf));
		assertThat(inputView.getWinningNumbers()).isEqualTo("2,12,18,35,56,62");
	}

}