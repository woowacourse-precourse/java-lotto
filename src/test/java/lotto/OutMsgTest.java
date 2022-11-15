package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutMsgTest {

	@DisplayName("저장된 구입 금액 입력 요청 메시지를 가져올 수 있어야 한다.")
	@Test
	void OutMsgEnumTest1() {
		String expected = "구입금액을 입력해 주세요.";
		assertThat(OutMsg.MONEY_REQUEST.getMessage()).isEqualTo(expected);
	}

	@DisplayName("저장된 보너스 번호 입력 요청 메시지를 가져올 수 있어야 한다")
	@Test
	void OutMsgEnumTest2() {
		String expected = "보너스 번호를 입력해 주세요.";
		assertThat(OutMsg.BONUS_REQUEST.getMessage()).isEqualTo(expected);
	}
}
