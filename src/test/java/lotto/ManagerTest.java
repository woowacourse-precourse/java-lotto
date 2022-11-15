package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManagerTest {

	@Test
	void 로또_구매_메서드_테스트(){
		String valid = "14000";
		Manager.buyLottos(valid);
		String notDivisible = "3589";
		assertThatThrownBy(() -> Manager.buyLottos(notDivisible))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(Message.ERROR.getMessage() + Message.NOT_DIVISIBLE_MONEY.getMessage());
	}
}
