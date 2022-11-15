package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MessageTest {
	@Test
	void 메시지_잘_나오는지(){
		String message = "구입금액을 입력해 주세요.";
		assertThat(Message.INPUT_PURCHASE_AMOUNT.getMessage()).isEqualTo(message);
	}
}
